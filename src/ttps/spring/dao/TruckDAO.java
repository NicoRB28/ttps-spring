package ttps.spring.dao;

import java.util.List;

import ttps.spring.model.Truck;



public interface TruckDAO extends GenericDAO<Truck>{
	
	List<Truck> findByServiceId(Long serviceId);
	Truck findByTruckname(String truckname);
	Truck findByUserId(Long userId);
	
}
