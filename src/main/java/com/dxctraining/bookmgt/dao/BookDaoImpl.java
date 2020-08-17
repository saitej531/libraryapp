package com.dxctraining.bookmgt.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dxctraining.bookmgt.entities.*;
import com.dxctraining.bookmgt.exception.BookNotFoundException;

@Repository
public abstract class BookDaoImpl implements IBookDao {
	
	@PersistenceContext
	private EntityManager entitymanager;

	private int generatedId;

	String generateId() {
		generatedId++;
		String isStr = "" + generateId();
		return isStr;
	}

	
	public Book findById(String id) {
		boolean exists = store.containsKey(id);
		if (!exists) {
			throw new BookNotFoundException("Book doesn't exists" + id);
		}
		Book book = store.get(id);
		return book;
	}

	
	public List<Book> findAll() {
		Collection<Book> collection = store.values();
		List<Book> list = new ArrayList();
		for (Book book : collection) {
			list.add(book);
		}
		return list;
	}

	public void add(Book book) {
		String id = generateId();
		store.put(id, book);
		book.setId(id);;
	}

	
	public void remove(String id) {
		store.remove(id);
	}


	public Book updateBook(String id, String name) {
		Book book = findById(id);
		book.setId(id);
		book.setName(name);
		return book;
	}

}
