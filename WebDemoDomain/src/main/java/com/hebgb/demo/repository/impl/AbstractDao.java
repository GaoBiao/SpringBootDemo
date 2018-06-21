package com.hebgb.demo.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao {
	@PersistenceContext
	protected EntityManager entityManager;
}
