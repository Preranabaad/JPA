package com.lti.ui;

import com.lti.service.UserService;

public class Main {
	private static UserService service;
	static{
		service = new UserService();
	}
	public static void main(String[] args) {
		boolean loginStatus = service.checkLogin("AW204_PC1", "India@123");
		if(loginStatus){
			System.out.println("Sucessful login... show the menu");
		}else{
			System.out.println("Invalid login...");
		}
	}
}
