package com.lti.service;

import java.util.List;

import com.lti.dao.UserDao;
import com.lti.model.Users;

public class UserService {
	UserDao dao = null;
	public UserService(){
		dao = new UserDao();
	}
	public boolean checkLogin(String username, String password){
		int result = dao.readLogin(username, password);
		if(result ==1)
			return true;
		else
			return false;
	}
	public List<Users> findAllUsers(){
		return dao.readAllUsers();
	}
	public boolean removeUser(String username){
		int result = dao.deleteUser(username);
		if(result ==1)
			return true;
		else
			return false;
	}
	public boolean addUser(Users user){
		int result = dao.createUser(user);
		if(result ==1)
			return true;
		else
			return false;
	}
	public boolean updateUser(Users user) {
		int result = dao.updateUser(user);
		if(result ==1)
			return true;
		else
			return false;
	}
}






