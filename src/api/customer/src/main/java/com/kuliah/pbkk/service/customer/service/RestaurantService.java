package com.kuliah.pbkk.service.customer.service;

import com.kuliah.pbkk.service.customer.entity.Restaurant;

public interface RestaurantService extends DataService<Restaurant> {
	public void populateWithUser(Restaurant restaurant, Long userId);
}
