package ttps.spring.service;

import java.util.List;

import ttps.spring.dto.CreateTruckDTO;
import ttps.spring.model.Truck;

public interface TruckService {
	
	public Truck createTruck(CreateTruckDTO createTruckDTO);
	
	public List<Truck> getTrucksByServiceId(Long serviceId);
	
	public Truck getTruckByUserId(Long userId);
	
	public void deleteTruckById(Long truckId);
	
	public Truck editTruck(Truck editedTruck);
	
	public void addService(Long truckId, Long serviceId);

	public void addValoration(Long truckId, Integer valoration);

	public Truck getTruckById(Long truckId);
}
