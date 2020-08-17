package com.dxctraining.bookmgt.entities;

import javax.persistence.Entity;

import com.dxctraining.authormgt.entities.Author;
@Entity
public class EngineeringBook extends Book {
	
	private String mechBook;
	private String autoBook;

	public EngineeringBook(String name, String id, Author author, String mechBook, String autoBook) {
		super(name, id, author);
		this.mechBook = mechBook;
		this.autoBook = autoBook;
	}

	public String getMechBook() {
		return mechBook;
	}

	public void setMechBook(String mechBook) {
		this.mechBook = mechBook;
	}

	public String getAutoBook() {
		return autoBook;
	}

	public void setAutoBook(String autoBook) {
		this.autoBook = autoBook;
	}

}


