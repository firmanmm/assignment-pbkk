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

import com.kuliah.pbkk.service.customer.entity.Restaurant;
import com.kuliah.pbkk.service.customer.repository.RestaurantRepository;;

@RestController
public class RestaurantController {
	
	//@Autowired
	//private RestaurantRepository restaurantRepository;
	
	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurant() {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@GetMapping("/restaurants/{id}")
	public Restaurant getRestaurantById(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PostMapping("/restaurants") 
	public Restaurant postRestaurant(
			@RequestBody Restaurant Restaurant) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PutMapping("/restaurants/{id}")
	public Restaurant putRestaurant(
			@PathVariable int id, 
			@RequestBody Restaurant Restaurant) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@DeleteMapping("/restaurants/{id}")
	public void deleteRestaurant(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
}
