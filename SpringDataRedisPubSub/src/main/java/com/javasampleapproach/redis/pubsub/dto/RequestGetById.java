package com.javasampleapproach.redis.pubsub.dto;

import java.io.Serializable;

public class RequestGetById implements Serializable {
     /**
     *
     */
    private static final long serialVersionUID = -6111092642958578337L;

    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RequestGetById [id=" + id + "]";
    }
    
}