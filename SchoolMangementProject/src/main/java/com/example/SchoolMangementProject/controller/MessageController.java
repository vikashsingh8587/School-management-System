package com.example.SchoolMangementProject.controller;

import com.example.SchoolMangementProject.entity.Message;
import com.example.SchoolMangementProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // Send a message
    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.sendMessage(message));
    }

    // Get all messages
//    @GetMapping
//    public ResponseEntity<List<Message>> getAllMessages() {
//        return ResponseEntity.ok(messageService.getMessagesForUser(String userId));
//    }

    // Get messages for a specific user (received)
    @GetMapping("/to/{userId}")
    public ResponseEntity<List<Message>> getMessagesToUser(@PathVariable String userId) {
        return ResponseEntity.ok(messageService.getMessagesForUser(userId));
    }

    // Get messages sent by a specific user
    @GetMapping("/from/{userId}")
    public ResponseEntity<List<Message>> getMessagesFromUser(@PathVariable String userId) {
        return ResponseEntity.ok(messageService.getMessagesFromUser(userId));
    }

    // Mark message as read
    @PutMapping("/{id}/read")
    public ResponseEntity<Message> markAsRead(@PathVariable String id) {
        return ResponseEntity.ok(messageService.markAsRead(id));
    }

    // Delete message
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
