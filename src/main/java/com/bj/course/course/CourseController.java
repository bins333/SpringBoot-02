package com.bj.course.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bj.course.topic.Topic;

/**
 * Rest controller annotation will mark this class as rest class.
 * 
 * @author bins
 *
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	/**
	 * Get all courses
	 * 
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {

		return courseService.getAllCourses(topicId);
	}

	/**
	 * Get specific course by passing path variable
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}

	/**
	 * add new course
	 * 
	 * @param course
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		// check the method type and Request body annotation
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	/**
	 * Update Course
	 * 
	 * @param course
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course, courseId);
	}

	/**
	 * Delete course by passing path variable
	 * 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		courseService.delectCourse(courseId);
	}

}
