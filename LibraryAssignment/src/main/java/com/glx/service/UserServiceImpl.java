package com.glx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glx.dao.UserDao;
import com.glx.model.BooksList;
import com.glx.model.User;

@Service("bookslistService")
public class UserServiceImpl implements UserService {

	UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save(User user) {
		{
			userDao.save(user);
		}
	}

	
	public boolean authenticate(String username, String password) {
		{
			return userDao.authenticate(username, password);
		}
	}


	public User showInfo(String username) {
			return userDao.showInfo(username);
	}


	public void update(User user) {
		userDao.update(user);
		
	}


	public boolean delete(int id) {
		return userDao.delete(id);
	}


	public User showInfobyID(int id) {
		return userDao.showInfobyID(id);
	}

	@Override
	public List<BooksList> getBooks(int userid) {
		return userDao.getBooks(userid);
	}
}
