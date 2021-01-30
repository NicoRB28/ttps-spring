package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;
import ttps.spring.service.FoodTruckerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/foodtrucker")
public class FoodTruckerController {
	
	@Autowired
	public FoodTruckerService foodtruckerService;
	
	@PostMapping("/create/foodtrucker")
	public FoodTrucker createFoodTrucker(@RequestBody UsuarioDTO dto) {
		return this.foodtruckerService.createFoodTrucker(dto);
	}
	
	@GetMapping("/{id}")
	public FoodTrucker getFoodTruckerById(@PathVariable Long id) {
		return this.foodtruckerService.getFoodTruckerById(id);
	}
	
	@GetMapping("/{id}/trucks")
	public List<Truck> getTrucks(@PathVariable Long id){
		return this.foodtruckerService.getTrucks(id);
	}
	
}
