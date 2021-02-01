package ttps.spring.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;
import ttps.spring.service.FoodTruckerService;

@Service
public class FoodTruckerServiceIml implements FoodTruckerService{
	
	@Autowired
	private FoodTruckerDAO foodTruckerDao;
	
	@Override
	public FoodTrucker getFoodTruckerById(Long id) {
		return this.foodTruckerDao.findById(id);
	}

	@Override
	public FoodTrucker createFoodTrucker(UsuarioDTO dto) {
		return this.foodTruckerDao.save(new FoodTrucker(dto));
	}

	@Override
	public List<Truck> getTrucks(Long id) {
		return this.foodTruckerDao.findTrucksById(id);
	}

	@Override
	public FoodTrucker updateTrucker(Long id, UsuarioDTO dto) {
		Optional<FoodTrucker> truckerDb = Optional.ofNullable(this.foodTruckerDao.findById(id));
		if(!truckerDb.isPresent()) {
			throw new ServiceException("Error al actualizar trucker["+ id.toString()+"].");
		}
		var trucker = truckerDb.get();
		trucker.setMail(dto.getMail());
		trucker.setUsername(dto.getUsername());
		trucker.setPassword(dto.getPassword());
		
		return this.foodTruckerDao.save(trucker);
	}

	@Override
	public void deleteTrucker(Long id) {
		this.foodTruckerDao.delete(id);
	}
}
