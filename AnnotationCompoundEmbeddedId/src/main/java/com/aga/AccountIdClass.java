package com.aga;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(AccountPk.class)
public class AccountIdClass {
	
	private Integer accountNumber;
	private String userId;
	private Integer accountBalance;
	
	public AccountIdClass() {
		
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Id
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Id
	public Integer getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Integer accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
}
