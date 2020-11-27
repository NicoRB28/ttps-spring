package ttps.spring.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.CreateTruckDTO;
import ttps.spring.dto.EditTruckDTO;
import ttps.spring.model.Truck;
import ttps.spring.service.TruckService;

@RestController
@RequestMapping("/truck")
public class TruckController {

	@Autowired
	private TruckService truckService;
	
	@PostMapping("")
	public ResponseEntity<?> createTruck(@RequestBody CreateTruckDTO dto) {
		Truck truck = null;
		try {
			truck = this.truckService.createTruck(dto);
		} catch (Exception e) {
			return new ResponseEntity<>("Error al crear truck", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Truck>(truck,HttpStatus.CREATED);
	}
	
	@GetMapping("/servicio/{serviceId}")
	public ResponseEntity<?> getTrucksByService(@PathVariable Long serviceId){
		List<Truck> trucks = this.truckService.getTrucksByServiceId(serviceId);
		
		return new ResponseEntity<>(trucks,HttpStatus.OK);
	}
	
	@DeleteMapping("/{truckId}")
	public ResponseEntity<?> deleteTruck(@PathVariable Long truckId){
		try {
			this.truckService.deleteTruckById(truckId);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{truckId}")
	public ResponseEntity<?> editTruck(@RequestBody EditTruckDTO dto,@PathVariable Long truckId){
		Truck data = new Truck(dto);
		Truck edited = null;
		try {
			data.setId(truckId);
			edited = this.truckService.editTruck(data);			
		} catch (Exception e) {
			return new ResponseEntity<>("No se ha podido modificar el Truck",HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(edited, HttpStatus.OK);
				
	}
}
