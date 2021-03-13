package ttps.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


import ttps.spring.dto.UsuarioDTO;

@Entity
public class FoodTrucker extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Truck> trucks;
	
	public FoodTrucker() {
		super();
	}
	
	public FoodTrucker(UsuarioDTO userDTO) {
		super(userDTO);
	}

	public List<Truck> getTruck() {
		return trucks;
	}

	public void setTruck(List<Truck> trucks) {
		this.trucks = trucks;
	}
	
	public void addTruck(Truck truck) {
		this.trucks.add(truck);
	}
	
	public void removeTruck(Truck truck) {
		this.trucks.remove(truck);
	}
	
	public Boolean isTrucker() {
		return true;
	}
}
