package com.glx.dao;

import java.util.List;
import java.util.Map;

import com.glx.model.BooksList;
import com.glx.model.User;

public interface BooksDao {
	public BooksList BooksshowInfo(int bookid);
	public void insert(BooksList book);
	public void update(BooksList book);
	public boolean delete(int id);
	public List<Object[]> createlist();
	public List<User> getUsers(int bookid);
}
