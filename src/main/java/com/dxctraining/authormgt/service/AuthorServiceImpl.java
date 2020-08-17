package com.dxctraining.authormgt.service;

import com.dxctraining.authormgt.entities.*;

import com.dxctraining.authormgt.exception.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.authormgt.dao.*;
@Transactional
@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	private IAuthorDao dao ;

	public void add(Author author) {
		dao.add(author);
	}

	public void remove(String id) {
		validateId(id);
		dao.remove(id);
	}

	public Author updateName(String id, String name) {
		validateId(id);
		validateName(name);
		return null;
	}

	public Author findById(String id) {
		validateId(id);
		Author author = dao.findById(id);
		return author;
	}

	public List<Author> findAll() {
		List<Author> list = dao.findAll();
		return list;
	}

	public void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("Name cannot be empty");
		}
	}

	public void validateId(String id) {
		if (id == null || id.isEmpty()) {
			throw new InvalidArgumentException("Id cannot be null");
		}

	}

}
