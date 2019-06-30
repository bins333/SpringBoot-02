package com.bj.course.topic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bj.course.topic.Topic;
import com.bj.course.topic.TopicService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

	@Autowired
	private TopicService topicService;

	@Test
	public void test() {
		topicService.addTopic(new Topic("java", "Java 8", "Java 8 details"));
		assertEquals("Java 8", topicService.getTopic("java").getName());
	}

}
