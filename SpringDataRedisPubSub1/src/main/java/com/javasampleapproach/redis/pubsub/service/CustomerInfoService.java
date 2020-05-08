package com.javasampleapproach.redis.pubsub.service;

import com.javasampleapproach.redis.pubsub.model.Customer;

public interface CustomerInfoService {
    
    Customer getById(Integer id);

    void print();
}