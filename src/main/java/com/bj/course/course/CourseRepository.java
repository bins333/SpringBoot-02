package com.bj.course.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA interface for Course Repository
 * 
 * @author bins
 *
 */
public interface CourseRepository extends CrudRepository<Course, String> {
	
	// use findBy > Object  > primary key (camel case)
	public List<Course> findByTopicId(String topicId);

}
