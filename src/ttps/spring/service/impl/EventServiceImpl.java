package ttps.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.EventDAO;
import ttps.spring.dto.EventDTO;
import ttps.spring.model.Event;
import ttps.spring.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventDAO eventDAO;
	
	@Override
	public Event createEvent(EventDTO newEvent) {
		Event event = new Event(newEvent);
		return this.eventDAO.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		return this.eventDAO.findAll();
	}
	
}
