package com.lti.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Department1;
import com.lti.model.Employee2;



public class Main {
	public static void main(String args[]){
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		Department1 dept1 = new Department1(10,"Development");
		Employee2 e1 = new Employee2(101,"Raghav",7000);
		Employee2 e2 = new Employee2(102,"Aamir",8000);
		Employee2 e3 = new Employee2(103,"Shivani",6500);
		
		dept1.addEmployee(e1);
		dept1.addEmployee(e2);
		dept1.addEmployee(e3);
		
		e1.setDepartment(dept1);
		e2.setDepartment(dept1);
		e3.setDepartment(dept1);
		
		entityManager.getTransaction().begin();
		entityManager.persist(dept1);
		entityManager.getTransaction().commit();
		
		
		
		

	
	
	}

}
