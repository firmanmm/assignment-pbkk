package com.kuliah.pbkk.service.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.Restaurant;
import com.kuliah.pbkk.service.customer.service.RestaurantService;;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/restaurants")
	public Iterable<Restaurant> getAllRestaurant() {
		return restaurantService.findAll();
	}
	
	@GetMapping("/restaurants/{id}")
	public Restaurant getRestaurantById(
			@PathVariable Long id) {
		return restaurantService.findById(id).get();
	}
	
	@PostMapping("/restaurants") 
	public Restaurant postRestaurant(
			@ModelAttribute Restaurant Restaurant) {
		return restaurantService.save(Restaurant);
	}
	
	@PutMapping("/restaurants/{id}")
	public Restaurant putRestaurant(
			@PathVariable Long id, 
			@ModelAttribute Restaurant Restaurant) {
		Restaurant.setId(id);
		return restaurantService.save(Restaurant);
	}
	
	@DeleteMapping("/restaurants/{id}")
	public void deleteRestaurant(
			@PathVariable Long id) {
		restaurantService.deleteById(id);
	}
}
