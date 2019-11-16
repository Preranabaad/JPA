package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Employee2")
public class Employee2 implements Serializable {
	@Id
	@Column(name="emp_id")
	private int employeeId;
	public Department1 getDepartment() {
		return department;
	}
	public void setDepartment(Department1 department) {
		this.department = department;
	}
	@Column(name="emp_name")
	private String employeeName;
	@Column(name="emp_sal")
	private double employeeSalary;
	
	@ManyToOne()
	@JoinColumn(name="dept_id")
	private Department1 department;
	public Employee2() {
		
	}
	public Employee2(int employeeId, String employeeName, double employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
}
