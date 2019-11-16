package com.lti.service;

import com.lti.dao.AccountDaoImpl;

public class AccountServiceImpl {
	AccountServiceImpl service = new AccountServiceImpl();
	AccountDaoImpl dao = new AccountDaoImpl();
	public double deposit(long accountNumber, int amount) {
		double result =dao.deposit(accountNumber, amount);
		return result;
	}
	
}
