package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Author;
import com.lti.model.Book;

import com.lti.utils.JpaUtils;

public class BookDaoImpl implements BookDao{
	private EntityManager entityManager;
	
	
	public BookDaoImpl() {
		entityManager = JpaUtils.getEntityManager();
		init();
	}
	public void init(){
		Book book = new Book();
		book.setISBN(123456);
		book.setPrice(600);
		book.setTitle("Ignited_Minds");
		
		Book book1 = new Book();
		book1.setISBN(1234567);
		book1.setPrice(350);
		book1.setTitle("Shiva_trilogy");
		
		Author author = new Author();
		author.setId(101);
		author.setName("Sam");
		
		author.addBook(book);
		
		
		Author author1 = new Author();
		author1.setId(102);
		author1.setName("Amish");
		author1.addBook(book1);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(author);
		entityManager.persist(author1);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Book> readAllBooks() {
		
		TypedQuery<Book> tquery= entityManager.createQuery("Select b from Book b",Book.class);	
		List<Book> list= tquery.getResultList();
		return list;
	}

	@Override
	public List<Book> readBooksByAuthorName(String authorName) {
		String jpql = "Select b from Book b Inner Join b.authors a where a.name=:name";
		TypedQuery<Book> tquery = entityManager.createQuery(jpql,Book.class);
		tquery.setParameter("name", authorName);
				
		return tquery.getResultList() ;
	}
	
	@Override
	public List<Author> readAuthorByID(long ISBN) {
		String jpql ="Select a from Author a Inner Join a.books b where b.ISBN=:id";
		TypedQuery<Author> tquery = entityManager.createQuery(jpql,Author.class);
		tquery.setParameter("id", ISBN);

		return tquery.getResultList();
	}
	

	@Override
	public List<Book> readBooksByPrice(double min, double max) {
		String query= "Select b from Book b where b.price Between "+min+" and "+max;
		
		TypedQuery<Book> tquery=entityManager.createQuery(query,Book.class);
		List<Book> list=tquery.getResultList();
		
		return list;
	
	}


	public void beginTransaction(){
		entityManager.getTransaction().begin();
	}
	
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	public void rollback() {
		entityManager.getTransaction().rollback();
	}
}
