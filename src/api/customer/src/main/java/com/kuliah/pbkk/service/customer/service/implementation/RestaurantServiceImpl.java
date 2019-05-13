package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuliah.pbkk.service.customer.entity.Restaurant;
import com.kuliah.pbkk.service.customer.entity.User;
import com.kuliah.pbkk.service.customer.exception.BadRequestException;
import com.kuliah.pbkk.service.customer.repository.RestaurantRepository;
import com.kuliah.pbkk.service.customer.service.RestaurantService;
import com.kuliah.pbkk.service.customer.service.UserService;

@Component("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private UserService userService;
	
	@Override
	public Restaurant save(Restaurant data) {
		return restaurantRepository.save(data);
	}

	@Override
	public void deleteById(Long id) {
		restaurantRepository.markDelete(id);
	}

	@Override
	public Iterable<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Optional<Restaurant> findById(Long id) {
		return restaurantRepository.findById(id);
	}

	@Override
	public Restaurant update(Restaurant data) {
		Restaurant original = restaurantRepository.findById(data.getId()).get();
		original.merge(data);
		return this.save(original);
	}

	@Override
	public void populateWithUser(Restaurant restaurant, Long userId) {
		try {
			User user = userService.findById(userId).get();
			restaurant.setPemilik(user);
		}catch (Exception e) {
			throw new BadRequestException("User "+userId.toString()+"can't be found!");
		}
		
	}
}
