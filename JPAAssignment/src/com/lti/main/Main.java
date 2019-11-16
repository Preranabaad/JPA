package com.lti.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Current;
import com.lti.model.Saving;
import com.lti.service.AccountServiceImpl;



public class Main {
	public static void main(String args[]){
		AccountServiceImpl service = new AccountServiceImpl();
	
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		long accountNumber;
		int amount;
		do{
		
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Fund Transfer");
			System.out.println("4.Exit");
	
			System.out.println("Enter your choice");
			
			switch (choice) {
			case 1:
				System.out.println("Enter your account number");
				System.out.println("Enter the amount you want to deposit");
				amount =sc.nextInt();
				accountNumber=sc.nextLong();
				double result =service.deposit(accountNumber,amount);
				System.out.println("your balance is: "+result);
				
				break;

			default:
				break;
			}
		}while(choice!=4);
		
		
		
		
		Saving s = new Saving(1000001,"Gayatri",5000,4.0);
		Current c = new Current(100000010,"LTI Ltd.",9000,5000);
		
		/*entityManager.getTransaction().begin();
		entityManager.persist(s);
		entityManager.persist(c);
		entityManager.getTransaction().commit();*/
		
	}

}
