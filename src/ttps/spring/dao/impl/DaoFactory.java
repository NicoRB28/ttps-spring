package ttps.spring.dao.impl;

import ttps.spring.dao.EventDAO;
import ttps.spring.dao.EventPlannerDAO;
import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.dao.ServiceDAO;
import ttps.spring.dao.TruckDAO;

public class DaoFactory {
	
	public static EventDAO getEventDAO() {
		return new EventDAOImpl();
	}
	
	public static TruckDAO getTruckDAO() {
		return new TruckDAOImpl();
	}
	
	public static FoodTruckerDAO getFoodTruckerDAO() {
		return new FoodTruckerDAOImpl();
	}
	
	public static EventPlannerDAO getEventPlannerDAO() {
		return new EventPlannerDAOImpl();
	}
	
	public static ServiceDAO getServiceDAO() {
		return new ServiceDAOImpl();
	}
	
	
}
