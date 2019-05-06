package com.kuliah.pbkk.service.customer.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuliah.pbkk.service.customer.entity.User;
import com.kuliah.pbkk.service.customer.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public Iterable<User> getAllUser() {
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(
			@PathVariable Long id) {
		return userService.findById(id).get();
	}
	
	@PostMapping("/users")
	public User postUser(
			@ModelAttribute User user) {
		return userService.save(user);
	}
	
	@PutMapping("/users/{id}")
	public User putUser(
			@PathVariable Long id, 
			@ModelAttribute User user) {
		user.setId(id);
		return userService.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(
			@PathVariable Long id) {
		userService.deleteById(id);
	}
}
