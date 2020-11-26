package ttps.spring.dao.impl;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.EventPlannerDAO;
import ttps.spring.model.EventPlanner;

@Repository
public class EventPlannerDAOImpl extends GenericDAOImpl<EventPlanner> implements EventPlannerDAO{

	public EventPlannerDAOImpl() {
		super(EventPlanner.class);
	}

}
