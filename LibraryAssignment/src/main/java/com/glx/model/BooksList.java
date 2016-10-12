package com.glx.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="BOOKSLIST")
public class BooksList {
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_BOOKSLIST",
            joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = {@JoinColumn(name = "userId")}
    )
	private Set<User> users = new HashSet<User>();
	
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "bookId")
	private int bookid;
	
	@Column(name = "Bookname")
	private String bookname;
	
	@Column(name = "BookAuthor")
	private String bookauthor;
	
	
    public Set<User> getUsers() {
        return users;
    }
	
	
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
}
