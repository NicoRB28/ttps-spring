package ttps.spring.service;

import java.util.List;

import ttps.spring.dto.EventDTO;
import ttps.spring.model.Event;

public interface EventService {
	
	public Event createEvent(EventDTO newEvent);
	
	public List<Event> getAllEvents();
	
	public void deleteEvent(Long id);
	
	public Event getById(Long id);
	
	public Event updateEvent(EventDTO data,Event editedEvent);
}
