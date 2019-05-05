package com.kuliah.pbkk.service.customer.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public Iterable<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Object getUserById(
			@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PostMapping("/users")
	public User postUser(
			@ModelAttribute User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public User putUser(
			@PathVariable Long id, 
			@RequestBody User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(
			@PathVariable Long id) {
		userRepository.deleteById(id);
	}
}
