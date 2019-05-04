package com.kuliah.pbkk.service.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.User;
import com.kuliah.pbkk.service.customer.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PostMapping("/users") 
	public User postUser(
			@RequestBody User User) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@PutMapping("/users/{id}")
	public User putUser(
			@PathVariable int id, 
			@RequestBody User User) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(
			@PathVariable int id) {
		throw new UnsupportedOperationException("Not Yet Implemented");
	}
}
