package com.kuliah.pbkk.service.customer.controller;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@GetMapping("/restaurants")
	public Iterable<Restaurant> getAllRestaurant() {
		return restaurantRepository.findAll();
	}
	
	@GetMapping("/restaurants/{id}")
	public Object getRestaurantById(
			@PathVariable Long id) {
		return restaurantRepository.findById(id);
	}
	
	@PostMapping("/restaurants") 
	public Restaurant postRestaurant(
			@RequestBody Restaurant Restaurant) {
		return restaurantRepository.save(Restaurant);
	}
	
	@PutMapping("/restaurants/{id}")
	public Restaurant putRestaurant(
			@PathVariable Long id, 
			@RequestBody Restaurant Restaurant) {
		Restaurant.setId(id);
		return restaurantRepository.save(Restaurant);
	}
	
	@DeleteMapping("/restaurants/{id}")
	public void deleteRestaurant(
			@PathVariable Long id) {
		restaurantRepository.deleteById(id);
	}
}
