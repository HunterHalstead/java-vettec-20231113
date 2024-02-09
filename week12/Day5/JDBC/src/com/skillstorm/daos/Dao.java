package com.skillstorm.daos;

import java.util.List;

public interface Dao<E, K> {
	
	E findById(K id);
	
	List<E> findAll();
	
	E save(E e);
	
	E update(E e);
	
	void delete(E e);
	
	void deleteById(K id);
}