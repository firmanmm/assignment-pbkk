package com.kuliah.pbkk.service.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
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

	@PreAuthorize("#oauth2.hasScope('read_restaurant')")
	@GetMapping("/restaurants")
	public Iterable<Restaurant> getAllRestaurant() {
		return restaurantService.findAll();
	}
	
	@PreAuthorize("#oauth2.hasScope('read_restaurant')")	
	@GetMapping("/restaurants/{id}")
	public Restaurant getRestaurantById(
			@PathVariable Long id) {
		return restaurantService.findById(id).get();
	}

	@PreAuthorize("#oauth2.hasScope('trust_restaurant')")	
	@PostMapping("/restaurants") 
	public Restaurant postRestaurant(
			@ModelAttribute Restaurant restaurant) {
		return restaurantService.save(restaurant);
	}
	
	@PreAuthorize("#oauth2.hasScope('trust_restaurant')")	
	@PutMapping("/restaurants/{id}")
	public Restaurant putRestaurant(
			@PathVariable Long id, 
			@ModelAttribute Restaurant restaurant) {
		restaurant.setId(id);
		return restaurantService.save(restaurant);
	}
	@PreAuthorize("#oauth2.hasScope('create_restaurant')")		
	@PatchMapping("/restaurants/{id}")
	public Restaurant patchRestaurant(
			@PathVariable Long id, 
			@ModelAttribute Restaurant restaurant) {
		restaurant.setId(id);
		return restaurantService.update(restaurant);
	}
	
	@PreAuthorize("#oauth2.hasScope('delete_restaurant')")	
	@DeleteMapping("/restaurants/{id}")
	public void deleteRestaurant(
			@PathVariable Long id) {
		restaurantService.deleteById(id);
	}
}
