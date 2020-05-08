package com.javasampleapproach.redis.pubsub.service;

import org.springframework.http.ResponseEntity;

public interface CustomerService {

    public ResponseEntity getById(Integer id);
    
}