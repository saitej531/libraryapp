package com.dxctraining.bookmgt.dao;

import java.util.List;

import com.dxctraining.bookmgt.entities.Book;

public interface IBookDao {
	
	void add(Book book);

	void remove(String id);

	Book updateName(String id, String name);

	Book findById(String id);

	List<Book> findAll();

	

}
