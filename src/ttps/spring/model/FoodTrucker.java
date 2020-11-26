package ttps.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import ttps.spring.dto.UsuarioDTO;

@Entity
public class FoodTrucker extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade=CascadeType.REMOVE)
	private Truck truck;
	
	public FoodTrucker() {
		super();
	}
	
	public FoodTrucker(UsuarioDTO userDTO) {
		super(userDTO);
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

}
