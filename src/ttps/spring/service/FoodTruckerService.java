package ttps.spring.service;

import java.util.List;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;

public interface FoodTruckerService {
	
	public FoodTrucker getFoodTruckerById(Long id);
	
	public FoodTrucker createFoodTrucker(UsuarioDTO dto);
	
	public List<Truck> getTrucks(Long id);

	public FoodTrucker updateTrucker(Long id, UsuarioDTO dto);

	public void deleteTrucker(Long id);

	public FoodTrucker addTruck(Long idTrucker, Long idTruck);
	
}
