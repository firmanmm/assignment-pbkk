package com.kuliah.pbkk.service.customer.repository;

import org.springframework.data.repository.CrudRepository;

import com.kuliah.pbkk.service.customer.entity.User;
import com.kuliah.pbkk.service.customer.service.UserService;

public interface UserRepository extends CrudRepository<User, Long> {
	public User getByNoIdentitas(String noIdentitas);
	public User getByEmail(String email);
	public User getByNoHandphone(String noHandphone);
}
