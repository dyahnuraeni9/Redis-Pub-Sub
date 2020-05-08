package com.javasampleapproach.redis.pubsub.config;

import com.javasampleapproach.redis.pubsub.service.CustomerService;
import com.javasampleapproach.redis.pubsub.service.impl.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
@ComponentScan("com.javasampleapproach.redis.pubsub")
public class ProducerConfig {
    
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;


    @Bean(name ="redis")
	CustomerService redisPublisher() {
		return new CustomerServiceImpl(redisTemplate, topicProducer());
	}

	@Bean(name="topicProducer")
	ChannelTopic topicProducer() {
		return new ChannelTopic("pubsub1");
	}
}