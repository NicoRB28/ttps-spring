package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.EventPlanner;
import ttps.spring.service.EventPlannerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/eventPlanner")
public class EventPlannerController {
	
	@Autowired
	public EventPlannerService eventPlannerService;
	
	@PostMapping("/create")
	public EventPlanner createEventPlanner(@RequestBody UsuarioDTO dto) {
		return this.eventPlannerService.createEventPlanner(dto);
	}
	
	@GetMapping("/{id}")
	public EventPlanner getEventPlanner(@PathVariable Long id) {
		return this.eventPlannerService.getEventPlannerById(id);
	}
	
}
