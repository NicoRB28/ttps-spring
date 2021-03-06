package ttps.spring.service;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.EventPlanner;

public interface EventPlannerService {
	
	public EventPlanner createEventPlanner(UsuarioDTO dto);
	
	public EventPlanner getEventPlannerById(Long id);

	public EventPlanner uptdateEventPlanner(Long id, UsuarioDTO dto);

	public void deleteEventPlanner(Long id);
}
