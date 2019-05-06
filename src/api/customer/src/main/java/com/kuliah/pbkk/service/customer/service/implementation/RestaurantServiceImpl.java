package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kuliah.pbkk.service.customer.entity.Restaurant;
import com.kuliah.pbkk.service.customer.repository.RestaurantRepository;
import com.kuliah.pbkk.service.customer.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant save(Restaurant data) {
		return restaurantRepository.save(data);
	}

	@Override
	public void deleteById(Long id) {
		restaurantRepository.deleteById(id);
	}

	@Override
	public Iterable<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Optional<Restaurant> findById(Long id) {
		return restaurantRepository.findById(id);
	}

}
