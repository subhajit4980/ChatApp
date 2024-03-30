package com.subhajit.ChatApp.Service;

import com.subhajit.ChatApp.Utils.AppConstants;
import com.subhajit.ChatApp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@Component
public class MessageListener {
    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = AppConstants.PRODUCER_TOPIC_NAME,
            groupId = AppConstants.GROUP_ID
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener..");
        System.out.println(message.toString());
        template.convertAndSend("/topic/group", message);
    }
}