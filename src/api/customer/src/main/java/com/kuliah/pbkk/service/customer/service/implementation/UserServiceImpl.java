package com.kuliah.pbkk.service.customer.service.implementation;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuliah.pbkk.service.customer.entity.User;
import com.kuliah.pbkk.service.customer.repository.UserRepository;
import com.kuliah.pbkk.service.customer.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User data) {
		if(data.getPassword() != null && data.getPassword().length > 0) {
			String hashed = BCrypt.hashpw(data.getPassword().toString(), BCrypt.gensalt());
			data.setPassword(hashed.getBytes());
		}
		return userRepository.save(data);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
	
}
