package com.lti.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Author")

public class Author {
	
	@Id
	
	private int  id;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="AuthorBook",joinColumns={@JoinColumn(name="Author_id")},inverseJoinColumns={@JoinColumn(name="Books_id")})	
	private Set<Book> books = new HashSet<>();
	
	
	public Author() {
		}

	public Author(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public void addBook(Book book){
		books.add(book);
		}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
}
