package com.javasampleapproach.redis.pubsub.controller;

import com.javasampleapproach.redis.pubsub.service.CustomerService;
import com.javasampleapproach.redis.pubsub.service.impl.CustomerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private CustomerServiceImpl CustomerService;


    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id){
            return CustomerService.getById(id);
    }
    
}