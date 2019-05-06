package com.kuliah.pbkk.service.customer.service;

import java.util.Optional;

public interface DataService<T> {
	public T save(T data);
	public T update(T data);
	public void deleteById(Long id);
	public Iterable<T> findAll();
	public Optional<T> findById(Long id);
}
