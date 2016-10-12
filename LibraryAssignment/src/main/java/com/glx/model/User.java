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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {
	
	
	
	
	@ManyToMany(mappedBy = "users" ,cascade = CascadeType.ALL)
	private Set<BooksList> books = new HashSet<BooksList>();
	
	public Set<BooksList> getBooks() {
		return books;
	}
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userId")
	private int id;
	
	@Size(min=6, max=15)
	@Pattern(regexp="^[a-zA-Z]+$")
	@Column(name = "Username")
	private String username;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})") 
	@Column(name = "Password")
	private String password;
	
	@NotEmpty
	@Pattern(regexp="^[\\p{L} .'-]+$")
	@Column(name = "Name")
	private String name;

	
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")
	@Column(name = "DateofBirth")
	private String dob;
	
	
	
 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
