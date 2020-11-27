package ttps.spring.service;

import java.util.List;

import ttps.spring.dto.CreateTruckDTO;
import ttps.spring.model.Truck;

public interface TruckService {
	
	public Truck createTruck(CreateTruckDTO createTruckDTO);
	
	public List<Truck> getTrucksByServiceId(Long serviceId);
	
	public void deleteTruckById(Long truckId);
	
	public Truck editTruck(Truck editedTruck);
}
