package ttps.spring.dao;

import java.util.List;

import ttps.spring.model.Truck;



public interface TruckDAO extends GenericDAO<Truck>{
	
	List<Truck> findByServiceId(long serviceId);
	Truck findByTruckname(String truckname);
	
}
