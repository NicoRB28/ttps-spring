package ttps.spring.service.impl;

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
	
}
