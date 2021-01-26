package ttps.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.service.FoodTruckerService;

@Service
public class FoodTruckerServiceIml implements FoodTruckerService{
	
	@Autowired
	private FoodTruckerDAO foodTruckerDao;
	
	@Override
	public FoodTrucker getFoodTruckerById(Long id) {
		return this.foodTruckerDao.findById(id);
	}

	@Override
	public FoodTrucker createFoodTrucker(FoodTrucker newFoodTrucker) {
		return this.foodTruckerDao.save(newFoodTrucker);
	}
}
