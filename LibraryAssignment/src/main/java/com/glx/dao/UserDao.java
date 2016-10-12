package com.glx.dao;

import java.util.List;

import com.glx.model.BooksList;
import com.glx.model.User;


public interface UserDao {
	public void save(User user);
	public boolean authenticate(String username,String password);
	public User showInfo(String username);
	public void update(User user);
	public boolean delete(int id);
	public User showInfobyID(int id);
	public List<BooksList> getBooks(int userid);
}
