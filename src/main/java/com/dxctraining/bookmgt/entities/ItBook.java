package com.dxctraining.bookmgt.entities;

import javax.persistence.Entity;

import com.dxctraining.authormgt.entities.Author;
@Entity
public class ItBook extends Book {
	
	private String language;
	private double version;

	public ItBook(String name, String id, Author author, String language, double version) {
		super(name,id,author);
		this.language = language;
		this.version = version;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public double hashcode() {
		return version;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || obj instanceof ItBook) {
			return false;
		}
		ItBook that = (ItBook) obj;
		boolean isequals = this.language.equals(that.language);
		return isequals;
	}

}


