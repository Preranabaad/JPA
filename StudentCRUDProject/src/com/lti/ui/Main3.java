package com.lti.ui;

import java.util.List;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main3 {

		private static StudentService service= null;
		
		static{
			service = new StudentServiceImpl();
		}
		public static void main(String[] args) {
			Student student = new Student(8,"Makarand",70.50);
			boolean result = service.addStudent(student);
			if(result){
					System.out.println("Student is added");
			}
			
			List<Student> list= service.findAllStudents();
			for(Student s : list){
				System.out.println(s);
			}

		}

	}


