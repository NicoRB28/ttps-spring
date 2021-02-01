package ttps.spring.service.impl;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.EventPlannerDAO;
import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.EventPlanner;
import ttps.spring.service.EventPlannerService;

@Service
public class EventPlannerServiceImpl implements EventPlannerService {
	
	@Autowired
	public EventPlannerDAO eventPlannerDAO;
	
	@Override
	public EventPlanner createEventPlanner(UsuarioDTO dto) {
		return this.eventPlannerDAO.save(new EventPlanner(dto));
	}

	@Override
	public EventPlanner getEventPlannerById(Long id) {
		return this.eventPlannerDAO.findById(id);
	}

	@Override
	public EventPlanner uptdateEventPlanner(Long id, UsuarioDTO dto) {
		
		Optional<EventPlanner> eventPlannerDb = Optional.ofNullable(this.getEventPlannerById(id));
		
		if(!eventPlannerDb.isPresent()) {
			throw new ServiceException("Error al actualizar el event planner["+ id.toString() + "].");
		}
		
		var planner = eventPlannerDb.get();
		
		planner.setMail(dto.getMail());
		planner.setPassword(dto.getPassword());
		planner.setUsername(dto.getUsername());
		
		return this.eventPlannerDAO.save(planner);
	}

	@Override
	public void deleteEventPlanner(Long id) {
		this.eventPlannerDAO.delete(id);		
	}
	
}
