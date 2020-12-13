package ttps.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.EventDTO;
import ttps.spring.service.EventService;

@RestController
@CrossOrigin("*")
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
}
