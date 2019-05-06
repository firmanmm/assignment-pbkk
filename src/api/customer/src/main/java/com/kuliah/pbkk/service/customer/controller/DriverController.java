package com.kuliah.pbkk.service.customer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.Driver;
import com.kuliah.pbkk.service.customer.service.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/drivers")
	public Iterable<Driver> getAllDriver() {
		return driverService.findAll();
		
	}
	
	@GetMapping("/drivers/{id}")
	public Driver getDriverById(
			@PathVariable Long id) {
		return driverService.findById(id).get();
	}
	
	@PostMapping("/drivers") 
	public Driver postDriver(
			@ModelAttribute Driver driver) {
		return driverService.save(driver);
	}
	
	@PutMapping("/drivers/{id}")
	public Driver putDriver(
			@PathVariable Long id, 
			@ModelAttribute Driver driver) {
		driver.setId(id);
		return driverService.save(driver);
	}
	
	@PatchMapping("/drivers/{id}")
	public Driver patchDriver(
			@PathVariable Long id, 
			@ModelAttribute Driver driver) {
		driver.setId(id);
		return driverService.update(driver);
	}
	
	@DeleteMapping("/drivers/{id}")
	public void deleteDriver(
			@PathVariable Long id) {
		driverService.deleteById(id);
	}
}
