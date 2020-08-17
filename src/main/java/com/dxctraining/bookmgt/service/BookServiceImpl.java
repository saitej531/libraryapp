package com.dxctraining.bookmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.bookmgt.dao.BookDaoImpl;
import com.dxctraining.bookmgt.dao.IBookDao;
import com.dxctraining.bookmgt.entities.*;
import com.dxctraining.bookmgt.exception.InvalidArgumentException;

@Transactional
@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private IBookDao dao ;

	
	public void add(Book book) {
		dao.add(book);

	}

	@Override
	public void remove(String id) {
		validateId(id);
		dao.remove(id);
	}

	
	public Book updateName(String id, String name) {
		validateId(id);
		validateName(name);
		return null;
	}

	
	public Book findById(String id) {
		validateId(id);
		Book book = dao.findById(id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		List<Book> list = dao.findAll();
		return list;
	}

	public void validateName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException(" Name cannot be empty");
		}
	}

	public void validateId(String id) {
		if (id == null || id.isEmpty()) {
			throw new InvalidArgumentException("Id cannot be empty");
		}
	}

	
	
}
