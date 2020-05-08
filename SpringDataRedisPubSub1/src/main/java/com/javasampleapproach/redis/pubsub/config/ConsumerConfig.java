package com.javasampleapproach.redis.pubsub.config;

import java.util.concurrent.Executors;

import com.javasampleapproach.redis.pubsub.consumer.CustomerInfoSubscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
@ComponentScan("com.javasampleapproach.redis.pubsub")
public class ConsumerConfig {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    
    @Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new CustomerInfoSubscriber());
	}

	@Bean
	RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(jedisConnectionFactory);
		container.addMessageListener(messageListener(), topicSubcriber());
		container.setTaskExecutor(Executors.newFixedThreadPool(4));
		return container;
	}

    @Bean(name="topicSubcriber")
	ChannelTopic topicSubcriber() {
		return new ChannelTopic("pubsub1");
	}
}