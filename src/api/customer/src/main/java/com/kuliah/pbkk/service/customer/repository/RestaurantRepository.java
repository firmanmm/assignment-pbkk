package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	@Query("UPDATE FROM restaurants SET `deleted_at` = CURRENT_TIMESTAMP WHERE id = ?1 AND `deleted_at` IS NULL")
	public void markDelete(Long id);
}
