package com.kuliah.pbkk.service.customer.repository;

import com.kuliah.pbkk.service.customer.entity.User;

public interface UserRepository extends Repository<User> {
	public User getByNoIdentitas(String noIdentitas);
	public User getByEmail(String email);
	public User getByNoHandphone(String noHandphone);
}
