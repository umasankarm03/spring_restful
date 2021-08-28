package com.mus.spring_restful.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mus.spring_restful.dao.entity.Vehicle;
import com.mus.spring_restful.repository.VehicleRepository;
import com.mus.spring_restful.utils.VehicleNotFoundException;

@RestController
public class VehicleController {
	
	//Repository injected as constructor into controller
	private final VehicleRepository repository;
	
	public VehicleController(VehicleRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/vehicles") // HTTP GET
	List<Vehicle> getAll(){
		return repository.findAll();
	}
	
	@PostMapping("/vehicle") // HTTP POST
	Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return repository.save(vehicle);
	}
	
	// get single item
	@GetMapping("/vehicles/{id}") // HTTP GET
	Vehicle getVehicle(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
	}
	
	// put single item
	@PutMapping("/vehicles/{id}")   // HTTP PUT
	Vehicle replaceVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {
		
		return repository.findById(id)
				.map(veh -> {
					veh.setModel(vehicle.getModel());
				    veh.setPrice(vehicle.getPrice());
					return repository.save(veh);
					}).orElseGet(() -> {
						vehicle.setId(id);
						return repository.save(vehicle);
					});
	}
	
	@DeleteMapping("/vehicles/{id}") // HTTP DELETE
	void deleteVehicle(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
