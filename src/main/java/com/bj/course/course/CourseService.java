package com.bj.course.course;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	final static Logger logger = Logger.getLogger(CourseService.class);

	@Autowired
	CourseRepository courseRepositiory;

	/**
	 * Get all Courses available in the DB
	 * 
	 * @return
	 */
	public List<Course> getAllCourses(String topicId) {
		logger.info("Get all Courses");
		List<Course> Courses = new ArrayList<Course>();
		courseRepositiory.findByTopicId(topicId).forEach(Courses::add);
		return Courses;
	}

	/**
	 * Get a particular course from DB
	 * 
	 * @param courseId
	 * @return
	 */
	public Course getCourse(String courseId) {
		logger.info("Get Courses" + courseId);
		return courseRepositiory.findOne(courseId);
	}

	/**
	 * Add new course
	 * 
	 * @param course
	 */
	public void addCourse(Course course) {
		logger.info("Adding new course to Courses");
		courseRepositiory.save(course);

	}

	/**
	 * Update existing course.
	 * <p>
	 * For add and update save will be the method which needs to be invoked </br>
	 * Based on the id annotation system will do the required operation implicitly.
	 * </p>
	 * 
	 * @param course
	 * @param id
	 */
	public void updateCourse(Course course, String id) {
		logger.info("Updating a course " + id);
		courseRepositiory.save(course);
	}

	/**
	 * Delete Course
	 * 
	 * @param id
	 */
	public void delectCourse(String id) {
		logger.info("Deleting cours " + id);
		try {
		courseRepositiory.delete(id);
		}catch(EmptyResultDataAccessException exception) {
			logger.error("Unable to delete course " +id , exception);
		}

	}

}
