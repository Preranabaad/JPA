package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Users;
import com.lti.utils.JpaUtils;

public class UserDao {
	EntityManager entityManager;
	public UserDao(){
		entityManager = JpaUtils.getEntityManager();
	}
	public int readLogin(String username, String password){
		String jpql = "Select u From Users u Where u.username='"+username+"' And u.password='"+password+"'";	
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		List<Users> list = tquery.getResultList();
		return list.size();
	}
	public List<Users> readAllUsers(){
		String jpql = "Select u From Users u";
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		List<Users> list = tquery.getResultList();
		return list;
	}
	public int deleteUser(String username){
		String jpql = "Delete From Users u Where u.username='"+username+"'";
		Query query = entityManager.createQuery(jpql);
		int result = query.executeUpdate();
		return result;
	}
	public int createUser(Users user){
		entityManager.persist(user);
		return 1;
	}
	public int updateUser(Users user) {
		String jpql = "Update Users u Set u.firstname='"+user.getFirstname()+"', u.lastname='"+user.getLastname()+"', u.mobilenumber='"+user.getMobilenumber()+"' Where u.username='"+user.getUsername()+"'";
		Query query = entityManager.createQuery(jpql);
		int result = query.executeUpdate();
		return result;
	}
}


	
	
	
	
	
	
	


