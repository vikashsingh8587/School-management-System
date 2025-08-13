package com.example.SchoolMangementProject.service;

import com.example.SchoolMangementProject.entity.Message;
import com.example.SchoolMangementProject.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    // 1. Send message
    public Message sendMessage(Message message) {
        message.setSentAt(LocalDateTime.now());
        message.setRead(false);
        return messageRepo.save(message);
    }

    // 2. Get message by ID
    public Optional<Message> getMessageById(String id) {
        return messageRepo.findById(id);
    }

    // 3. Get all messages sent to a user
    public List<Message> getMessagesForUser(String toUserId) {
        return messageRepo.findByToUserId(toUserId);
    }

    // 4. Get all messages sent by a user
    public List<Message> getMessagesFromUser(String fromUserId) {
        return messageRepo.findByFromUserId(fromUserId);
    }

    // 5. Mark message as read
    public Message markAsRead(String id) {
        Optional<Message> optionalMessage = messageRepo.findById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setRead(true);
            return messageRepo.save(message);
        }
        return null;
    }

    // 6. Delete message
    public boolean deleteMessage(String id) {
        if (messageRepo.existsById(id)) {
            messageRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
