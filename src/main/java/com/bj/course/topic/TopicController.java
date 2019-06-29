package com.bj.course.topic;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller annotation will mark this class as rest class. 
 * @author bins
 *
 */
@RestController
public class TopicController {

	// create instance through DI
	// Service instance
	@Autowired
	private TopicService topicService;

	/**
	 * Default URL
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String test() {
		return Calendar.getInstance().getTime().toString();
	}

	/**
	 * Get all topics
	 * 
	 * @return
	 */
	@RequestMapping("/topics")
	public List<Topic> getTopics() {

		return topicService.getTopics();
	}

	/**
	 * Get specific topic by passing path variable
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	/**
	 * add new topic
	 * 
	 * @param topic
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		// check the method type and Request body annotation
		topicService.addTopic(topic);
	}

	/**
	 * Update Topic
	 * 
	 * @param topic
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}

	/**
	 * Delete topic by passing path variable
	 * 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.delectTopic(id);
	}

}
