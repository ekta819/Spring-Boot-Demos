package learn.sb.datajpa1.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import learn.sb.datajpa1.main.entities.Student;
import learn.sb.datajpa1.main.service.StudentService;
import learn.sb.datajpa1.main.service.StudentServiceImpl;

@SpringBootApplication
public class SbDemo5SbDataJpaCrud1Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(SbDemo5SbDataJpaCrud1Application.class, args);
		StudentService studentService= context.getBean(StudentServiceImpl.class);
		
		//---------------------To add 1 Student details ------------------------------
		/*
		Student stu1=new Student("Hyaa","2","97");
		boolean sts = studentService.addStudentDetails(stu1);
		if(sts=true) {
			System.out.println("Student details added successfully");
		}
		else {
			System.out.println("Not added. Try Again");
		}*/
		
		
		//---------------------To add multiple Student details ------------------------------
		/*
		Student stu1=new Student("Hyaa","2","97");
		Student stu2=new Student("Soremon","3","87");
		Student stu3=new Student("Shinachan","4","90");
		Student stu4=new Student("Nobita","5","100");
		List<Student> stuList=new ArrayList<Student>(); 
		stuList.add(stu1);
		stuList.add(stu3);
		stuList.add(stu4);
		stuList.add(stu2);
		
		boolean sts = studentService.addMultipleStudentDetails(stuList);
		if(sts=true) {
			System.out.println("Student details added successfully");
		}
		else {
			System.out.println("Not added. Try Again");
		}
		*/
		
		//---------------------To SELECT All Student details -----------------------------
		/*
		List<Student> stuList=studentService.getAllStudentDetails();
		for(Student s : stuList) {
			System.out.println(s.getMarks()+"   "+s.getName()+"   "+s.getRollno()+"   "+s.getMarks());
			System.out.println("---------------------------------------------------------------------");
		}
		*/
		
		//---------------------To SELECT  Student details by ID -----------------------------
		/*
		Student std =studentService.getStudentDetailsById(10L);
		if(std!=null) {
			System.out.println(std.getId());
			System.out.println(std.getName());
			System.out.println(std.getRollno());
			System.out.println(std.getMarks());
		}
		else {
			System.out.println("ID not found");
		}
		*/
		
		//---------------------To UPDATE  Student details by ID -----------------------------
		
		boolean sts=studentService.updateStudentDetails(2L, "87");
		try {
			if(sts) {
				System.out.println("Student details updated successfully");
			}
			else {
				System.out.println("Not updated. Try Again");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
