package com.lti.ui;

import java.util.List;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main4 {

		private static StudentService service= null;
		
		static{
			service = new StudentServiceImpl();
		}
		public static void main(String[] args) {
			List<Student> list= service.findStudentByScore(50, 70);
			if(list!=null && list.size()>0)
			{
			for(Student s : list){
				System.out.println(s);
			}
			}
			else {
				
				System.out.println("there is no record");
			}

		}

	}


