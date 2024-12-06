package learn.sb.datajpa1.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sb.datajpa1.main.entities.Student;
import learn.sb.datajpa1.main.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	//---------------------To add 1 Student details ------------------------------
	@Override
	public boolean addStudentDetails(Student std) {
		boolean status=false;
		
		try {
			 studentRepo.save(std);
			 status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		return status;

	}
	
	//---------------------To add multiple Student details ------------------------------
	@Override
	public boolean addMultipleStudentDetails(List<Student> stdList) {
		boolean status=false;
		try {
			studentRepo.saveAll(stdList);
			status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			status=false;
		}
		return false;
	}
	
	//---------------------To SELECT All Student details -----------------------------
	@Override
	public List<Student> getAllStudentDetails() {
		return studentRepo.findAll();
		
	}

	
	//---------------------To SELECT  Student details by ID -----------------------------
	@Override
	public Student getStudentDetailsById(long id) {
		 Optional<Student> optional= studentRepo.findById(id);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		 else {
			 return null;
		 }		
		
	}
	
	
	//---------------------To UPDATE  Student details by ID -----------------------------
	@Override
	public boolean updateStudentDetails(long id, String marks) {
		//boolean status=false;
		Student student=getStudentDetailsById(id);
		if(student!=null) {
			student.setMarks(marks);
			studentRepo.save(student);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	

}
