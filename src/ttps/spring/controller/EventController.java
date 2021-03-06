package ttps.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.EventDTO;
import ttps.spring.model.Event;
import ttps.spring.service.EventService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("")
	public List<EventDTO> getAllEvents(){ 
		return this.eventService.getAllEvents()
				   				.stream()
				   				.map(EventDTO::new)
				   				.collect(Collectors.toList()); 
	}
	
	@PostMapping("/newEvent")
	public EventDTO createEvent(@RequestBody EventDTO newEvent) {
		this.eventService.createEvent(newEvent);
		return newEvent;
	}
	
	@DeleteMapping("/{eventId}")
	public void deleteEvent(@PathVariable Long eventId) {
		this.eventService.deleteEvent(eventId);
	}
	
	@PutMapping("/{eventId}")
	public EventDTO updateEvent(@PathVariable Long eventId, @RequestBody EventDTO updatedEvent) {
		Event eventDb = this.eventService.getById(eventId);
		eventDb = this.eventService.updateEvent(updatedEvent,eventDb);
		return new EventDTO(eventDb);
	}
}	
