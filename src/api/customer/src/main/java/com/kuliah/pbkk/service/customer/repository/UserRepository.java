package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User getByNoIdentitas(String noIdentitas);
	public User getByEmail(String email);
	public User getByNoHandphone(String noHandphone);
	@Query("UPDATE FROM users SET `deleted_at` = CURRENT_TIMESTAMP() WHERE id = ?1 AND `deleted_at` IS NULL")
	public void markDelete(Long id);
}
