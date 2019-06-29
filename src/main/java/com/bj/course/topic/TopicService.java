package com.bj.course.topic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	final static Logger logger = Logger.getLogger(TopicService.class);

	@Autowired
	TopicRepository topicRepositiory;

	/**
	 * Get all topics available in the DB
	 * 
	 * @return
	 */
	public List<Topic> getTopics() {
		logger.info("Get all topics");
		List<Topic> topics = new ArrayList<Topic>();
		topicRepositiory.findAll().forEach(topics::add);
		return topics;
	}

	/**
	 * Get a particular topic from DB
	 * 
	 * @param topicId
	 * @return
	 */
	public Topic getTopic(String topicId) {
		logger.info("Get topics" + topicId);
		return topicRepositiory.findOne(topicId);
	}

	/**
	 * Add new topic
	 * 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		logger.info("Adding new topic to topics");
		topicRepositiory.save(topic);

	}

	/**
	 * Update existing topic.
	 * <p>
	 * For add and update save will be the method which needs to be invoked </br>
	 * Based on the id annotation system will do the required operation implicitly.
	 * </p>
	 * 
	 * @param topic
	 * @param id
	 */
	public void updateTopic(Topic topic, String id) {
		logger.info("Updating a topic " + id);
		topicRepositiory.save(topic);
	}

	/**
	 * Delete topic
	 * 
	 * @param id
	 */
	public void delectTopic(String id) {
		logger.info("Deleting topic " + id);
		try {
		topicRepositiory.delete(id);
		}catch(EmptyResultDataAccessException exception) {
			logger.error("Unable to delete topic " +id , exception);
		}

	}

}
