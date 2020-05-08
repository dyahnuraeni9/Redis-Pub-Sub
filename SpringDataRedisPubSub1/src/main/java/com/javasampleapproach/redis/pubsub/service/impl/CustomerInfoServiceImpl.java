package com.javasampleapproach.redis.pubsub.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.javasampleapproach.redis.pubsub.model.Customer;
import com.javasampleapproach.redis.pubsub.service.CustomerInfoService;

import org.springframework.stereotype.Service;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    List<Customer> customers = new ArrayList<>(
           Arrays.asList(new Customer(1, "Jack", "Smith"),
            new Customer(2, "Adam", "Johnson"),
            new Customer(3, "Kim", "Smith"),
            new Customer(4, "David", "Williams"),
            new Customer(5, "Peter", "Davis")));
            
    @Override
    public Customer getById(Integer id) {
        System.out.println("123 : ");
        Customer cust = customers.get(id);
        System.out.println("Data Customer : "+cust);
        return cust ;
    }

    @Override
    public void print() {
       System.out.println("Hiiiiiii");

    }
    
}