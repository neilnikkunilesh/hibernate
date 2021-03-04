package com.aga;

import java.io.Serializable;

import javax.persistence.Embeddable;

import javassist.expr.Instanceof;

/* Composite Primary Key Class	*/
//@Embeddable
public class AccountPk implements Serializable{
	
	private String userId;
	private Integer accountNumber;
	public AccountPk() {
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountPk(String userId, Integer accountNumber) {
		super();
		this.userId = userId;
		this.accountNumber = accountNumber;
	}
	
	public int hashCode() {
		int hashCode = 0;
		if(userId !=null) {
			hashCode ^=accountNumber.hashCode();
		}
		if(accountNumber != null)
			hashCode ^=accountNumber.hashCode();
		System.out.println("Inside hashCode() method....:"+hashCode);
		
		return hashCode;
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof AccountPk)) {
			return false;
		}
		AccountPk target = (AccountPk) obj;
		System.out.println("Inside equals() methods...");
		if(this.userId.equals(target.userId) && this.accountNumber.equals(target.accountNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
}
