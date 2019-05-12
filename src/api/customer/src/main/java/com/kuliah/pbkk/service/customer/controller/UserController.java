package com.kuliah.pbkk.service.customer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("#oauth2.hasScope('read_user')")
	@GetMapping("/users")
	public Iterable<User> getAllUser() {
		return userService.findAll();
	}
	
	@PreAuthorize("#oauth2.hasScope('read_user')")
	@GetMapping("/users/{id}")
	public User getUserById(
			@PathVariable Long id) {
		return userService.findById(id).get();
	}
	
	@PreAuthorize("#oauth2.hasScope('trust_user')")
	@PostMapping("/users")
	public User postUser(
			@ModelAttribute User user) {
		return userService.save(user);
	}
	
	@PreAuthorize("#oauth2.hasScope('trust_user')")
	@PutMapping("/users/{id}")
	public User putUser(
			@PathVariable Long id, 
			@ModelAttribute User user) {
		user.setId(id);
		return userService.save(user);
	}
	
	@PreAuthorize("#oauth2.hasScope('write_user')")
	@PatchMapping("/users/{id}")
	public User patchUser(
			@PathVariable Long id, 
			@ModelAttribute User user) {
		user.setId(id);
		return userService.update(user);
	}
	
	@PreAuthorize("#oauth2.hasScope('delete_user')")
	@DeleteMapping("/users/{id}")
	public void deleteUser(
			@PathVariable Long id) {
		userService.deleteById(id);
	}
}
