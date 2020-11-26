package ttps.spring.dao.impl;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.EventDAO;
import ttps.spring.model.Event;

@Repository
public class EventDAOImpl extends GenericDAOImpl<Event> implements EventDAO{

	public EventDAOImpl() {
		super(Event.class);
	}

}
