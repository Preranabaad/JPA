package com.lti.ui;

import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main2 {
	private static StudentService service= null;
	
	static{
		service = new StudentServiceImpl();
	}

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int choice;
		int id;
		double marks;
		String name;
		int score;
		Student student = new Student();
	do{	
		System.out.println("Options: 1. Add 2. Read 3. Modify 4. Delete 5.Exit");
		System.out.println("Enter your choice");
		 choice=sc.nextInt();	
		switch (choice) {
		case 1: 
			System.out.println("Enter the ID :");
			id=sc.nextInt();
			System.out.println("Enter the name:");
			name=sc.next();
			System.out.println("Enter the avg score");
			score=sc.nextInt();
			
			student = new Student(id, name, score);
			boolean result = service.addStudent(student);
			if(result){
					System.out.println("Student is added");
			}
					
			
			break;
		case 2:
			System.out.println("Enter the ID : ");
			id=sc.nextInt();
		 student= service.findStudentByRollNumber(id);
			System.out.println(student);
			break;
			
		case 3:
			System.out.println("Enter the ID : ");
			id=sc.nextInt();
			student = service.findStudentByRollNumber(id);
			System.out.println("Enter the changed marks");
			marks=sc.nextDouble();
		    
			student.setAvgScore(marks);
			
			student = service.modifyStudent(student);
			System.out.println(student);
			break;
			
		case 4:
			System.out.println("Enter the ID : ");
			id=sc.nextInt();
		   boolean result1 = service.removeStudent(id);
			System.out.println("Deleted");		
			break;

		default:
			break;
		}
	}while(choice!=5);

	}
	

}
