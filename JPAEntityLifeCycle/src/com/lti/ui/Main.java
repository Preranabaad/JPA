package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		
	EntityManagerFactory factory=	Persistence.createEntityManagerFactory("JPA_PU");
	EntityManager entitymanager = factory.createEntityManager();
		Student student = new Student(1,"ash",80);
	/*student.setStudentName("aamir");
		student.setAvgScore(80);
	entitymanager.getTransaction().begin();
		entitymanager.persist(student);
		entitymanager.getTransaction().commit();
		student.setAvgScore(75);
		
		System.out.println("Student is persited in the database. ");
		*/
		
		entitymanager.getTransaction().begin();
		entitymanager.remove(student);
		entitymanager.getTransaction().commit();
		System.out.println("Student is removed from the database. ");
		
		
	
	
	}

}
