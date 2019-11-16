package com.lti.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Student;

public class Main {

	public static void main(String[] args) {
		Student student= new Student(4,"Siya",60.5);
		//JPA API
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		System.out.println("Student object saved");
		
		System.out.println("After saving student object:");
		Student student1 = entityManager.find(Student.class, student.getRollNumber() );
		System.out.println(student1);
		
		student1.setAvgScore(66.5);
		System.out.println("After update student object: ");
		
		entityManager.getTransaction().begin();
		entityManager.merge(student1);
		entityManager.getTransaction().commit();
		
		student1 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student1);
		
		System.out.println("After remove student object");
		entityManager.getTransaction().begin();
		entityManager.remove(student1);
		entityManager.getTransaction().commit();
		student1 = entityManager.find(Student.class, student.getRollNumber());
		System.out.println(student1);
	}

}
