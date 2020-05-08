package com.javasampleapproach.redis.pubsub.config;

import com.javasampleapproach.redis.pubsub.consumer.CustomerInfoSubscriber;
import com.javasampleapproach.redis.pubsub.producer.CustomerInfoPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

@Configuration
@ComponentScan("com.javasampleapproach.redis.pubsub")
public class ProducerConfig {
    
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
	CustomerInfoSubscriber redisPublisher() {
		return new CustomerInfoSubscriber(redisTemplate, topicProducer());
	}

    @Bean(name="topicProducer")
	ChannelTopic topicProducer() {
		return new ChannelTopic("pubsub2");
	}
}
