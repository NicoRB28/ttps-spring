package ttps.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import ttps.spring.dto.UsuarioDTO;

@Entity
public class EventPlanner extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "eventPlanner", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Event> eventos;

	public EventPlanner() {
		super();
		this.eventos = new ArrayList<>();
	}
	
	public EventPlanner(UsuarioDTO userDTO) {
		super(userDTO);
		this.eventos = new ArrayList<>();
	}

	public List<Event> getEventos() {
		return eventos;
	}

	public void setEventos(List<Event> eventos) {
		this.eventos = eventos;
	}

	public void addEvent(Event event) {
		this.eventos.add(event);
	}
}
