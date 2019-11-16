package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Account;

public class AccountDaoImpl {
	EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
	EntityManager entityManager = factory.createEntityManager();
	
	public double deposit(long accountNumber,double transactionAmount ){
		Account acc=entityManager.find(Account.class,accountNumber);
		double newbalance=acc.getAccountBalance()+transactionAmount;
		acc.setAccountBalance(newbalance);
		entityManager.merge(acc);
		return acc.getAccountBalance();
	}
	
	public void withdraw(long accountNumber, double transactionAmount){
		Account acc=entityManager.find(Account.class,accountNumber);
		double newbalance=acc.getAccountBalance()-transactionAmount;
		acc.setAccountBalance(newbalance);
		entityManager.merge(acc);
	}

}