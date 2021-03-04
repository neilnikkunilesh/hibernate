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
	private int publisherNo;
	private int cost;
	private int author1No;
	private int author2No;
	private int author3No;
	private int author4No;
	
	public Books() {
		
	}
	
	

	public Books(Integer bookNo, String bookName, int publisherNo, int cost, int author1No, int author2No,
			int author3No, int author4No) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.publisherNo = publisherNo;
		this.cost = cost;
		this.author1No = author1No;
		this.author2No = author2No;
		this.author3No = author3No;
		this.author4No = author4No;
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

	public int getPublisherNo() {
		return publisherNo;
	}

	public void setPublisherNo(int publisherNo) {
		this.publisherNo = publisherNo;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAuthor1No() {
		return author1No;
	}

	public void setAuthor1No(int author1No) {
		this.author1No = author1No;
	}

	public int getAuthor2No() {
		return author2No;
	}

	public void setAuthor2No(int author2No) {
		this.author2No = author2No;
	}

	public int getAuthor3No() {
		return author3No;
	}

	public void setAuthor3No(int author3No) {
		this.author3No = author3No;
	}

	public int getAuthor4No() {
		return author4No;
	}

	public void setAuthor4No(int author4No) {
		this.author4No = author4No;
	}

	
	
}
