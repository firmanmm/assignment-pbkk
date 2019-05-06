package com.kuliah.pbkk.service.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.Driver;
import com.kuliah.pbkk.service.customer.repository.DriverRepository;

@RestController
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDriver() {
		return driverRepository.findAll();
		
	}
	
	@GetMapping("/drivers/{id}")
	public Driver getDriverById(
			@PathVariable int id) {
		return driverRepository.findAll(id);
	}
	
	@PostMapping("/drivers") 
	public Driver postDriver(
			@RequestBody Driver driver) {
		return driverRepository.save(Driver);
	}
	
	@PutMapping("/drivers/{id}")
	public Driver putDriver(
			@PathVariable int id, 
			@RequestBody Driver driver) {
		Driver.setId(id);
		return driverRepository.save(Driver);
	}
	
	@DeleteMapping("/drivers/{id}")
	public void deleteDriver(
			@PathVariable int id) {
		driverRepository.deleteById(id);
	}
}
