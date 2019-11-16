package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Author;

public class Main {

	public static void main(String[] args) {
		Author author = new Author(1,"Amish","Om","Trivedi",89745632);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(author);
		manager.getTransaction().commit();
		
		System.out.println("Author added: "+ author);
		
		Author author2 = manager.find(Author.class, author.getAuthorId());
		author2.setLastName("jay");
		
		manager.getTransaction().begin();
		manager.merge(author2);
		manager.getTransaction().commit();
		
		author2 = manager.find(Author.class, author.getAuthorId());
		System.out.println("After saving : "+ author2);
		
		manager.getTransaction().begin();
		manager.remove(author2);
		manager.getTransaction().commit();
		author2 = manager.find(Author.class, author.getAuthorId());
		System.out.println("After deleting: "+author2);
		
		
	}

}
