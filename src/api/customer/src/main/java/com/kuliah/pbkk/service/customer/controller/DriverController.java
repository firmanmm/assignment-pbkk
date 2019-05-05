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
	
	//@Autowired
	//private DriverRepository driverRepository;
	
	@GetMapping("/drivers")
	public List<Driver> getAllDriver() {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@GetMapping("/drivers/{id}")
	public Driver getDriverById(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PostMapping("/drivers") 
	public Driver postDriver(
			@RequestBody Driver driver) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PutMapping("/drivers/{id}")
	public Driver putDriver(
			@PathVariable int id, 
			@RequestBody Driver driver) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@DeleteMapping("/drivers/{id}")
	public void deleteDriver(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
}
