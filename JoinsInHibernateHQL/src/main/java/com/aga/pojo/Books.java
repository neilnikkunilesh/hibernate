package com.aga.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Books {

	@Id
	@GeneratedValue
	private Integer bookNo;
	private String bookName;
	private String isbn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Authors authors;
	
	public Books() {
		
	}


	public Books(String bookName, String isbn, Authors authors) {
		super();
		this.bookName = bookName;
		this.isbn = isbn;
		this.authors = authors;
	}



	public Integer getBookNo() {
		return bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Authors getAuthors() {
		return authors;
	}


	public void setAuthors(Authors authors) {
		this.authors = authors;
	}


	@Override
	public String toString() {
		return "Books [bookNo=" + bookNo + ", bookName=" + bookName + ", isbn=" + isbn + ", authors=" + authors + "]";
	}

	
	
}
