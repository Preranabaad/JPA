package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public Student readStudentByRollNumber(int rollNumber);
	public List<Student> readAllStudent();
	public Student updateStudent(Student student);
	public List<Student> readStudentByScore(double min,double max);
	public List<Student> readStudentByName(String name);
	
	
	public int deleteStudent(int rollNumber);
	public void beginTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
}
