package com.kuliah.pbkk.service.customer.service.implementation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T>{
	@Autowired
    private EntityManagerFactory entityManagerFactory;

	protected CriteriaBuilder getBuilder() {
		return entityManagerFactory.getCriteriaBuilder();
	}
	
	public abstract T update(T data);
}
