package com.xcompany.dao;

import java.util.List;

public interface Dao <T>{
	
	void create(T item);
	
	List<T> readAll();
	
	void update(T item);
	
	void delete(int id);	
}
