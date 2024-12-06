package learn.spring.restapi.SbRestMysqlJpa1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import learn.spring.restapi.SbRestMysqlJpa1.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(1, "Core Java", "This for basic java"));
		list.add(new Course(2, "Spring Core", "This for core spring"));
		list.add(new Course(3, "Rset Api", "This for Rest API"));
	}
	

	@Override
	public List<Course> getCourse() {
		return list;
	}


	@Override
	public Course getCourseWithId(long courseId) {
		Course c=null;
		for(Course course :list)
		{
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	
	
	

}
