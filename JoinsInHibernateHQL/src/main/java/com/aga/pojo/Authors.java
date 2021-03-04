package com.aga.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Authors {

	@Id
	@GeneratedValue
	private Integer authorNo;
	private String authorName;
	private String email;
	private String address;
	@OneToMany(mappedBy = "authors")
	private Set<Books> bookeses = new HashSet<Books>();
	
	public Authors() {
		
	}
	
	public Authors(String authorName, String email, String address) {
		super();
		this.authorName = authorName;
		this.email = email;
		this.address = address;
	}

	public Integer getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(Integer authorNo) {
		this.authorNo = authorNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Books> getBookeses() {
		return bookeses;
	}
	public void setBookeses(Set<Books> bookeses) {
		this.bookeses = bookeses;
	}
	
	
	
}
