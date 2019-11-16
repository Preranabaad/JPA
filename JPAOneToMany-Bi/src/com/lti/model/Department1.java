package com.lti.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Department1")
public class Department1 implements Serializable {
	@Id
	@Column(name="dept_id")
	private int departmentId;
	@Column(name="dept_name")
	private String departmentName;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set<Employee2> employees=new HashSet<>();
	public Department1() {
	
	}
	public Department1(int departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public void addEmployee(Employee2 emp){
		employees.add(emp);
		
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Employee2> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee2> employees) {
		this.employees = employees;
	}
	
}
