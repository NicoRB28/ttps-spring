package ttps.spring.dao.impl;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;

@Repository
public class FoodTruckerDAOImpl extends GenericDAOImpl<FoodTrucker> implements FoodTruckerDAO{

	public FoodTruckerDAOImpl() {
		super(FoodTrucker.class);
	}

}
