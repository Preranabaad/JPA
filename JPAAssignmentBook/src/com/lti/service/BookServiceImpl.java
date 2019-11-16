package com.lti.service;

import java.util.List;

import com.lti.dao.BookDao;
import com.lti.dao.BookDaoImpl;
import com.lti.model.Author;
import com.lti.model.Book;

public class BookServiceImpl implements BookService {
	 BookDao dao;
	
	public BookServiceImpl(){
		 dao= new BookDaoImpl();
	}
  
	@Override
	public List<Book> findAllBooks() {
		
		return dao.readAllBooks(); 
	}

	@Override
	public List<Book> findBookByAuthorName(String authorName) {
	
		return dao.readBooksByAuthorName(authorName);
	}

	@Override
	public List<Book> findBookByPrice(double min, double max) {
		
		return dao.readBooksByPrice(min, max);
	}

	@Override
	public List<Author> findAuthorById(long ISBN) {
		
		return dao.readAuthorByID(ISBN);
	}
	
}
