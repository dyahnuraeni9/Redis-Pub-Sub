package com.javasampleapproach.redis.pubsub.service.impl;

import com.javasampleapproach.redis.pubsub.dto.RequestGetById;
import com.javasampleapproach.redis.pubsub.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("topicProducer")
    private ChannelTopic topic;

    public CustomerServiceImpl() {
	}

    public CustomerServiceImpl(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.topic = topic;
	}

    @Override
    public ResponseEntity getById(Integer id) {
        //RequestGetById request = new RequestGetById();
       // request.setId(String.valueOf(id));
        System.out.println("Publishing Data with ID =" + id + ", " + Thread.currentThread().getName()+ "from topic "+topic.getTopic());
        redisTemplate.convertAndSend(topic.getTopic(), id);
        return null;
    }
    
}