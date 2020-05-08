package com.javasampleapproach.redis.pubsub.producer;

import com.javasampleapproach.redis.pubsub.model.Customer;

public interface CustomerInfoPublisher {
	
	void publish(Customer cust);
}
