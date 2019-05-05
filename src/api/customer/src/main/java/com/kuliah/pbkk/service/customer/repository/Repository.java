package com.kuliah.pbkk.service.customer.repository;

import java.util.List;

public interface Repository<T> {
	public T save(T data);
	public T findById(int id);
	public List<T> getAll();
	public List<T> getAll(int limit, int offset);
	public Boolean deleteById(int id);
}
