package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kuliah.pbkk.service.customer.entity.Restaurant;
import com.kuliah.pbkk.service.customer.entity.User;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
	public Restaurant getByIdentifier(String identitifer);
	@Transactional
	@Modifying
	@Query(value="UPDATE restaurants SET deleted_at = NOW() WHERE id = ?1 AND deleted_at IS NULL",nativeQuery=true)
	public void markDelete(Long id);
}
