package com.aga;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	private AccountPk compositeId;
	private int accountBalance;
	
	/* Annotate the component property as @Id and make the component class @Embeddable	*/
	//@Id
	@EmbeddedId
	public AccountPk getCompositeId() {
		return compositeId;
	}
	public void setCompositeId(AccountPk compositeId) {
		this.compositeId = compositeId;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Account() {
	}
	
	
}
