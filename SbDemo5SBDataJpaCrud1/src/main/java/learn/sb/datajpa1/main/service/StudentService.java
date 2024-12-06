package learn.sb.datajpa1.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import learn.sb.datajpa1.main.entities.Student;

//@Service
public interface StudentService {
	
	//---------------------To add 1 Student details ------------------------------
	public boolean addStudentDetails(Student std);
	
	//---------------------To add multiple Student details ------------------------------
		public boolean addMultipleStudentDetails(List<Student> stdList);
		
	//---------------------To SELECT All Student details -----------------------------
		public List<Student> getAllStudentDetails();
	
		//---------------------To SELECT  Student details by ID -----------------------------
		public Student getStudentDetailsById(long id);
		
		//---------------------To UPDATE  Student details by ID -----------------------------
		public boolean updateStudentDetails(long id, String marks);
		
		
}
