package com.glx.service;

import java.util.List;

import com.glx.model.BooksList;
import com.glx.model.User;

public interface BookService {
	public void insert(BooksList books);
	public void update(BooksList book);
	public boolean delete(int bookid);
	public BooksList BooksshowInfo(int bookid);
	public List<Object[]> createlist();
	public List<User> getUsers(int bookid);
}
