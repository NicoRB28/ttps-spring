package ttps.spring.dao;

import java.util.List;

import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;

public interface FoodTruckerDAO extends GenericDAO<FoodTrucker>{
	
	public List<Truck> findTrucksById(Long id);
}
