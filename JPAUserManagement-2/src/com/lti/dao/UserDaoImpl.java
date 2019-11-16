package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Users;
import com.lti.utils.JpaUtils;

public class UserDaoImpl implements UserDao{
	EntityManager entityManager;
	public UserDaoImpl(){
		entityManager = JpaUtils.getEntityManager();
	}
	public int readLogin(String username, String password){
		//String jpql = "Select u From Users u Where u.username='"+username+"' And u.password='"+password+"'";	
		String jpql = "Select u From Users u Where u.username=:user And u.password=:pass";	
		
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		tquery.setParameter("user", username);
		tquery.setParameter("pass", password);
		List<Users> list = tquery.getResultList();
		return list.size();
	}
	public List<Users> readAllUsers(){
		entityManager.clear();
		String jpql = "Select u From Users u";
		TypedQuery<Users> tquery = entityManager.createQuery(jpql, Users.class);
		List<Users> list = tquery.getResultList();
		return list;
	}
	public int deleteUser(String username){
		String jpql = "Delete From Users u Where u.username=:user";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("user", username);
		int result = query.executeUpdate();
		return result;
	}
	public int createUser(Users user){
		entityManager.persist(user);
		return 1;
	}
	public int updateUser(Users user) {
		//String jpql = "Update Users u Set u.firstname='"+user.getFirstname()+"', u.lastname='"+user.getLastname()+"', u.mobile='"+user.getMobile()+"' Where u.username='"+user.getUsername()+"'";
		String jpql = "Update Users u Set u.firstname=:fname, u.lastname=:lname, u.mobile=:mobile Where u.username=:user";
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("fname", user.getFirstname());
		query.setParameter("lname", user.getLastname());
		query.setParameter("mobile", user.getMobile());
		query.setParameter("user", user.getUsername());
		int result = query.executeUpdate();
		return result;
	}
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
		
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
		
	}
	@Override
	public void rollbackTransaction() {
		entityManager.getTransaction().rollback();
		
	}
}


	
	
	
	
	
	
	


