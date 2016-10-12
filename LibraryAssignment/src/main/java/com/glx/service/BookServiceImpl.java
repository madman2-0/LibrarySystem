package com.glx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glx.dao.BooksDao;
import com.glx.model.BooksList;
import com.glx.model.User;

@Service("bookService")
public class BookServiceImpl implements BookService {

	BooksDao booksDao;
	@Autowired
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}
	
	public void insert(BooksList book) {
			booksDao.insert(book);
	}

	


	public void update(BooksList book) {
		booksDao.update(book);
		
	}


	public boolean delete(int bookid) {
		return booksDao.delete(bookid);
	}


	public BooksList BooksshowInfo(int bookid) {
		return booksDao.BooksshowInfo(bookid);
	}

	@Override
	public List<Object[]> createlist() {
		return booksDao.createlist();
	}

	@Override
	public List<User> getUsers(int bookid) {
		// TODO Auto-generated method stub
		return booksDao.getUsers(bookid);
	}
}
