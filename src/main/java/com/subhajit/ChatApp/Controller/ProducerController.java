package com.subhajit.ChatApp.Controller;

import com.subhajit.ChatApp.Service.MessageProducerService;
import com.subhajit.ChatApp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/chat")
public class ProducerController {
    @Autowired
    private MessageProducerService messageProducerService;

    @PostMapping(value = "/send", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        messageProducerService.sendMessage(message);
        return ResponseEntity.ok("Success!");
    }
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        return message;
    }
    @MessageMapping("/newUser")
    @SendTo("/topic/group")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        (headerAccessor.getSessionAttributes()).put("username", message.getSender());
        return message;
    }
}
