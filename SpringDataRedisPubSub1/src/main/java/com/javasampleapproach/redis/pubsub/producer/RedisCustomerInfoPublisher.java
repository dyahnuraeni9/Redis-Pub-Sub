package com.javasampleapproach.redis.pubsub.producer;

// import java.util.concurrent.atomic.AtomicInteger;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.listener.ChannelTopic;
// import org.springframework.stereotype.Service;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.javasampleapproach.redis.pubsub.model.Customer;

// @Service
// public class RedisCustomerInfoPublisher implements CustomerInfoPublisher {

	// private final AtomicInteger counter = new AtomicInteger(0);

	// @Autowired
	// private RedisTemplate<String, Object> redisTemplate;

	// @Autowired
	// @Qualifier("topicProducer")
	// private ChannelTopic topic;

	// public RedisCustomerInfoPublisher() {
	// }

	// public RedisCustomerInfoPublisher(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
	// 	this.redisTemplate = redisTemplate;
	// 	this.topic = topic;
	// }

	// @Override
	// public void publish(Customer cust) {
	// 	String json = "";
	// 	System.out.println(cust);
	// 	ObjectMapper mapper = new ObjectMapper();
	// 	try {
	// 		json = mapper.writeValueAsString(cust);
	// 	} catch (JsonProcessingException e) {
	// 		e.printStackTrace();
	// 	}
	// 	System.out.println(
	// 			"Publishing... customer with id=" + cust.getId() + ", " + Thread.currentThread().getName()+ "from topic "+topic.getTopic());

	// 	redisTemplate.convertAndSend(topic.getTopic(), json);
	// }

//}
