package com.lti.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Order;
import com.lti.model.Product;



public class Main {
	public static void main(String args[]){
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		Product elecProduct=new Product();
		elecProduct.setProductId(1);
		elecProduct.setProductName("LEDTV");
		elecProduct.setProductPrice(1000);
		
		Product beautyProduct = new Product();
		beautyProduct.setProductId(2);
		beautyProduct.setProductName("FaceWash");
		beautyProduct.setProductPrice(80);
		
		Product babyProduct = new Product();
		babyProduct.setProductId(3);
		babyProduct.setProductName("pampers");
		babyProduct.setProductPrice(30);
		
		Product eleProduct =new Product();
		eleProduct.setProductId(4);
		eleProduct.setProductName("CFLbulb");
		eleProduct.setProductPrice(300);
		
		Order firstOrder=new Order();
		firstOrder.setOrderId(1000);
		firstOrder.setPurchaseDate(new Date());
		
		firstOrder.addProduct(eleProduct);
		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(beautyProduct);	
		
		
		Order secondOrder = new Order();
		secondOrder.setOrderId(1001);
		secondOrder.setPurchaseDate(new Date());
		
		secondOrder.addProduct(babyProduct);
		secondOrder.addProduct(eleProduct);
		secondOrder.addProduct(elecProduct);
		
		entityManager.getTransaction().begin();
		entityManager.persist(firstOrder);
		entityManager.persist(secondOrder);
		entityManager.getTransaction().commit();
		
	
	
	}

}
