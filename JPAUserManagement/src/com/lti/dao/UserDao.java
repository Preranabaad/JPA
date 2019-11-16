package com.lti.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.lti.model.Users;
import com.lti.utils.JpaUtils;

public class UserDao {
	private EntityManager entityManager;
	 public UserDao(){
		 entityManager = JpaUtils.getEntityManager();
	 }
	public int readLogin(String username, String password){
		
			String jpql = "Select u From Users u Where u.username='"+username+ "' and u.password= '"+password+"'";
			TypedQuery<Users> tquery= entityManager.createQuery(jpql, Users.class);
			List<Users> list = tquery.getResultList();
			return list.size();
	}
	public List<Users> readAllUsers(){
		
		TypedQuery<Users> tquery=entityManager.createQuery("Select u from Users u",Users.class);
		List<Users> list= tquery.getResultList();
		return list;
	}
	
	public int deleteUser(String username){
		Query query= entityManager.createQuery("Delete u from Users u where username="+username);
		int result = query.executeUpdate();
		return result;
		
	}
	public int createUser(Users user){
	entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return 1;
	}
	public int updateUser(Users user) {
		
		Query query= entityManager.createQuery("Update u  from Users u set firstname='"+user.getFirstname()+"',lastname='"+user.getLastname()+"',mobile='"+user.getMobile()+"' where u.username='"+user.getUsername()+"'");

		int result = query.executeUpdate();
		return result;
		
		
		
	}
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}

	
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}

}


	
	
	
	
	
	
	


