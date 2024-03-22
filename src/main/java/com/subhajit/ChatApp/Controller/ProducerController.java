package com.subhajit.ChatApp.Controller;

import com.subhajit.ChatApp.Service.MessageProducerService;
import com.subhajit.ChatApp.Utils.AppConstants;
import com.subhajit.ChatApp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        messageProducerService.sendMessage(message);
        return ResponseEntity.ok("Success!");
    }
}
