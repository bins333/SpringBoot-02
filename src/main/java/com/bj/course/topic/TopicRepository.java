package com.bj.course.topic;

import org.springframework.data.repository.CrudRepository;

/**
 * JPA interface for Topic Repository
 * 
 * @author bins
 *
 */
public interface TopicRepository extends CrudRepository<Topic, String> {

}
