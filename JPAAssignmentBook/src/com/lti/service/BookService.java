package com.lti.service;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface BookService {
	public List<Book> findAllBooks();
	public List<Book> findBookByAuthorName( String authorName);
	public List<Book> findBookByPrice(double min, double max);
	public List<Author> findAuthorById(long id);
}
