package com.dxctraining.bookmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import com.dxctraining.authormgt.entities.Author;
 
@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Book {
	
	@Id
	@GeneratedValue
	private String id;
	private String name;
	
	@ManyToOne
	private Author author;
	
	
	public Book(String name, String id, Author author) {
		this.name = name;
		this.id = id;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int hashCode() {
		int hashCode = id.hashCode();
		return hashCode;
	}

	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		} else if ((null == arg) || !(arg instanceof Book)) {
			return false;
		}
		Book that = (Book) arg;
		boolean isequals = this.id.equals(that.id);
		return isequals;
	}
	
	

}
