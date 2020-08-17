package com.dxctraining.authormgt.dao;

import com.dxctraining.authormgt.entities.*;

import com.dxctraining.authormgt.exception.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl implements IAuthorDao {

	@PersistenceContext
	private EntityManager entitymanager;

	private int generateId;

	String generateId() {
		generateId++;
		String idStr = "" + generateId();
		return idStr;
	}

	@Override
	public void add(Author author) {
		String id = generateId();
		store.put(id, author);
		author.setId(id);
	}

	public void remove(String id) {
		store.remove(id);

	}

	public Author updateName(String id, String name) {
		Author author = findById(id);
		author.setName(name);
		return author;
	}

	public Author findById(String id) {
		boolean exists = store.containsKey(id);
		if (!exists) {
			throw new AuthorNotFoundException("Author doesn't exists" + id);
		}
		Author author = store.get(id);
		return author;
	}

	public List<Author> findAll() {
		Collection<Author> collection = store.values();
		List<Author> list = new ArrayList<>();
		for (Author author : collection) {
			list.add(author);
		}
		return list;
	}

}
