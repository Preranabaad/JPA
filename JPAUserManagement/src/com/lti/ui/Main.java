package com.lti.ui;

import java.util.List;
import java.util.Scanner;

import com.lti.model.Users;
import com.lti.service.UserService;

public class Main {

	public static void main(String[] args) {
		UserService service =new UserService();
		Scanner sc= new Scanner(System.in);
		String username;
		String password;
		System.out.println("Enter the username :");
		username= sc.next();
		System.out.println("Enter the password :");
		password= sc.next();
		
		
		int choice;
		Users user = new Users();
		
		
		boolean result= service.checkLogin(username, password);
		if(result){
			do{	
				System.out.println("Options: 1. Add 2. Read 3. Modify 4. Delete 5.Exit");
				System.out.println("Enter your choice");
				 choice=sc.nextInt();	
				switch (choice) {
				
				case 1:
					System.out.println("Enter the username ");
					service.addUser(user);
					
				
				case 2:
				List<Users> list=service.findAllUsers();
				System.out.println(list);
				
			
	
				
				}
			
			}while(choice!=5);
			
		}
		else{
			System.out.println("invalid username and password");
		}
		
	}

}
