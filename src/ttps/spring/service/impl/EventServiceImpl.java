package ttps.spring.service.impl;

import java.util.List;
import java.util.Objects;

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

	@Override
	public void deleteEvent(Long id) {
		this.eventDAO.delete(id);
	}

	@Override
	public Event getById(Long id) {
		return this.eventDAO.findById(id);
	}

	@Override
	public Event updateEvent(EventDTO data,Event editedEvent) {
		Objects.requireNonNull(data);
		this.setValues(data, editedEvent);
		this.eventDAO.update(editedEvent);
		return editedEvent;
	}

	private void setValues(EventDTO data, Event editedEvent) {
		editedEvent.setAdress(data.getAddress());
		editedEvent.setCity(data.getCity());
		editedEvent.setDayAndTime(data.getDayAndTime());
		editedEvent.setDescription(data.getDescription());
		editedEvent.setEmail(data.getMail());
		//editedEvent.setEventPlanner();
		//editedEvent.setTrucks();
		editedEvent.setLatitude(data.getLatitude());
		editedEvent.setLongitude(data.getLongitude());
		editedEvent.setName(data.getName());
		editedEvent.setPayment(data.getPayment());
		editedEvent.setPhone(data.getPhone());
		editedEvent.setProvince(data.getProvince());
		editedEvent.setState(data.getState());
		editedEvent.setZipCode(data.getZipCode());
	}
	
	
}
