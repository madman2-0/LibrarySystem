package com.glx.model;

import java.util.List;

import javax.persistence.Entity;
@Entity
public class Books {
	private List<Integer> book;

	public List<Integer> getBook() {
		return book;
	}

	public void setBook(List<Integer> book) {
		this.book = book;
	}  
	  
}
