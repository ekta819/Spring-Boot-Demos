package learn.spring.restapi.SbRestMysqlJpa1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learn.spring.restapi.SbRestMysqlJpa1.entities.Course;
import learn.spring.restapi.SbRestMysqlJpa1.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseServ;
	
	@GetMapping("/home")
	
	public String home() {
		return "This is home";
		
	}
	
	//Get All Courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseServ.getCourse();
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Course getCourseWithId(@PathVariable String courseId){
		return this.courseServ.getCourseWithId(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course){
		return this.courseServ.addCourse(course);
	}
	
	
}
