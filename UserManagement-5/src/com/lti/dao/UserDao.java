package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.Users;

public class UserDao {
	private Connection conn;
	
	private void openConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}
	private void closeConnection(){
		try{
			conn.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int readLogin(String username, String password){
		try{
			openConnection();
			String query = "Select * From Users Where Username=? And Password=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet reuslt = pstmt.executeQuery();
			if(reuslt.next()){
				pstmt.close();
				return 1;
			}
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		return 0;
	}
	public List<Users> readAllUsers(){
		List<Users> users = null;
		try{
			openConnection();
			String query = "Select * From Users";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			users = new ArrayList<>();
			while(result.next()){
				String uname = result.getString("Username");
				String fname = result.getString("Firstname");
				String lname = result.getString("Lastname");
				String mobile = result.getString("Mobile");
				Users user = new Users(uname, null, fname, lname, mobile);
				users.add(user);
			}
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return users;
	}
	
	public int deleteUser(String username){
		int result = 0;
		try{
			openConnection();
			String query = "Delete From Users Where Username = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			result = pstmt.executeUpdate();
		}
		catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return result;
	}
	public int createUser(Users user){
		int result = 0;
		try {
			openConnection();
			String query = "Insert Into Users(Username, Password, Firstname, Lastname, mobile) Values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getFirstname());
			pstmt.setString(4, user.getLastname());
			pstmt.setString(5, user.getMobile());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;
	}
	public int updateUser(Users user) {
		int result =0;
		try{
			openConnection();
			String query="Update users set Firstname=?, Lastname=?,mobile=? where Username=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,user.getFirstname());
			pstmt.setString(2, user.getLastname());
			pstmt.setString(3, user.getMobile());
			pstmt.setString(4, user.getUsername());
			result = pstmt.executeUpdate();
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return result;
		
		
		
	}
}


	
	
	
	
	
	
	


