package com.lti.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
public class Transaction {
	private long transactionId;
	private int transactionAmount;
	
	public Transaction(){
		
	}
	
	
	public Transaction(long transactionId, int transactionAmount, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.account = account;
	}
	@ManyToOne()
	@JoinColumn(name="accountNumber")
	private Account account;
	
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	

}
