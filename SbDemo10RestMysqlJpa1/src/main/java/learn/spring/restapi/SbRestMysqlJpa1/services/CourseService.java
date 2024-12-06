package learn.spring.restapi.SbRestMysqlJpa1.services;

import java.util.List;

import learn.spring.restapi.SbRestMysqlJpa1.entities.Course;

public interface CourseService {
	public List<Course> getCourse();

	public Course getCourseWithId(long courseId);

	public Course addCourse(Course course);

}
