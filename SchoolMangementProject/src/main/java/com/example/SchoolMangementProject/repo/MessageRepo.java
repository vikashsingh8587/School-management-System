package com.example.SchoolMangementProject.repo;

import com.example.SchoolMangementProject.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepo extends MongoRepository<Message,String> {
    List<Message> findByToUserId(String toUserId);
    List<Message> findByFromUserId(String fromUserId);
}
