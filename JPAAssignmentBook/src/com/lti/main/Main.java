package com.lti.main;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;
import com.lti.model.Book;
import com.lti.service.BookService;
import com.lti.service.BookServiceImpl;



public class Main {
	private static BookService services=null;
	static{
		services = new BookServiceImpl();
	}
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
									
		/*EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();*/
		
		
		
						
		List<Book> list=services.findAllBooks();
		System.out.println(list);
		
		/*System.out.println("Enter the min and max price");
		double min = sc.nextDouble();
		double max = sc.nextDouble();
		List<Book> list1=services.findBookByPrice(min, max);
		System.out.println(list1);*/
		
		System.out.println("Enter the book id for the author name");
		long ISBN = sc.nextLong();
		List<Author> author2 = services.findAuthorById(ISBN);
		System.out.println(author2);
		
	/*	System.out.println("Enter the author name");
		String name = sc.next();
		List<Book> book2 = services.findBookByAuthorName(name);
		System.out.println(book2);
		*/

		
		
}

}
