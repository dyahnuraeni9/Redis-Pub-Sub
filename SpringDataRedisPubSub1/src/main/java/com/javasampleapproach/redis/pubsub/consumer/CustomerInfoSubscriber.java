package com.javasampleapproach.redis.pubsub.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.javasampleapproach.redis.pubsub.model.Customer;
import com.javasampleapproach.redis.pubsub.model.RequestGetById;
import com.javasampleapproach.redis.pubsub.service.CustomerInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

public class CustomerInfoSubscriber implements MessageListener {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Autowired
	@Qualifier("topicProducer")
	private ChannelTopic topic;

	List<Customer> customers = new ArrayList<>(
		Arrays.asList(new Customer(1, "Jack", "Smith"),
		 new Customer(2, "Adam", "Johnson"),
		 new Customer(3, "Kim", "Smith"),
		 new Customer(4, "David", "Williams"),
		 new Customer(5, "Peter", "Davis")));

	@Autowired
	private CustomerInfoService customerService;

	public CustomerInfoSubscriber() {
	}

	public CustomerInfoSubscriber(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.topic = topic;
	}


	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println("Received Data : " + message );
		// RequestGetById request = (RequestGetById) redisSerializer.deserialize(message.getBody());
		// System.out.println("Request : " + request );
		String payload = message.toString();
		System.out.println("Data >> " + payload + " type " + message.getBody() + ", " + Thread.currentThread().getName());
		Integer id = Integer.parseInt(payload) - 1;
		Customer cust = customers.get(id);
		// String json = "";
		 System.out.println(cust);
		 redisTemplate.convertAndSend("", cust);
		

	}

	public void print(Customer cust){
		System.out.println("Data :" + cust);
		System.out.println("topic :" + topic.getTopic());	
		System.out.println("Dek");
	}

}
