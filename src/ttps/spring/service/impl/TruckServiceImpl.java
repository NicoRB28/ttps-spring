package ttps.spring.service.impl;

import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.dao.ServiceDAO;
import ttps.spring.dao.TruckDAO;
import ttps.spring.dto.CreateTruckDTO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;
import ttps.spring.service.TruckService;

@Service
public class TruckServiceImpl implements TruckService {

	@Autowired
	private TruckDAO truckDAO;
	
	@Autowired
	private FoodTruckerDAO foodtruckerDAO; 
	
	@Autowired
	private ServiceDAO serviceDAO;
	
	@Override
	public Truck createTruck(CreateTruckDTO createTruckDTO)throws ConstraintViolationException {
		Objects.requireNonNull(createTruckDTO,"La request no puede ser nula");
		
		FoodTrucker owner = this.foodtruckerDAO.findById(createTruckDTO.getOwnerId());
		
		Truck newTruck = new Truck(createTruckDTO, owner );
		this.truckDAO.save(newTruck);
		
		owner.addTruck(newTruck);
		this.foodtruckerDAO.update(owner);
		
		return newTruck;
	}

	@Override
	public List<Truck> getTrucksByServiceId(Long serviceId) {
		Objects.requireNonNull(serviceId);
		return this.truckDAO.findByServiceId(serviceId);
		
	}
	
	public void deleteTruckById(Long truckId) {
		Objects.requireNonNull(truckId);
		Truck truckDB = this.getTruckById(truckId);
		FoodTrucker owner = this.foodtruckerDAO.findById(truckDB.getOwner().getId());
		owner.setTruck(null);
		this.foodtruckerDAO.update(owner);
		this.truckDAO.delete(truckId);
	}

	@Override
	public Truck editTruck(Truck editedTruck) {
		
		Truck truckDb = this.truckDAO.findById(editedTruck.getId());
		
		truckDb.setDescription(editedTruck.getDescription());
		truckDb.setInstagram(editedTruck.getInstagram());
		truckDb.setName(editedTruck.getName());
		truckDb.setTwitter(editedTruck.getTwitter());
		truckDb.setUri(editedTruck.getUri());
		truckDb.setWhatsapp(editedTruck.getWhatsapp());
		this.truckDAO.update(truckDb);
		
		return truckDb;
	}

	@Override
	public void addService(Long truckId, Long serviceId) {
		Objects.requireNonNull(truckId);
		Objects.requireNonNull(serviceId);
		
		Truck truckDb = this.truckDAO.findById(truckId);
		ttps.spring.model.Service service = this.serviceDAO.findById(serviceId);
		
		truckDb.addService(service);
		this.truckDAO.update(truckDb);
	}

	@Override
	public void addValoration(Long truckId, Integer valoration) {
		Truck truckDb = this.truckDAO.findById(truckId);
		
		truckDb.addValoration(valoration);
		
		this.truckDAO.update(truckDb);
		
	}

	@Override
	public Truck getTruckById(Long truckId) {
		Objects.requireNonNull(truckId);
		return this.truckDAO.findById(truckId);
	}

	@Override
	public Truck getTruckByUserId(Long userId) {
		return this.truckDAO.findByUserId(userId);
	}

}
