package ttps.spring.service;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.FoodTrucker;

public interface FoodTruckerService {
	
	public FoodTrucker getFoodTruckerById(Long id);
	
	public FoodTrucker createFoodTrucker(UsuarioDTO dto);
	
}
