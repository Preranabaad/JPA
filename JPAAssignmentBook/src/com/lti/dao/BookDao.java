package com.lti.dao;

import java.util.List;

import com.lti.model.Author;
import com.lti.model.Book;

public interface BookDao {
	public List<Book> readAllBooks();
	public List<Book> readBooksByAuthorName(String authorName);
	public List<Book> readBooksByPrice(double min, double max);
	public List<Author> readAuthorByID(long id);
}
