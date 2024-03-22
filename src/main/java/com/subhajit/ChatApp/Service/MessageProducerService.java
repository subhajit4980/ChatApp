package com.subhajit.ChatApp.Service;

import com.subhajit.ChatApp.Utils.AppConstants;
import com.subhajit.ChatApp.model.Message;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
    @Autowired
    private KafkaTemplate<String,Message> kafkaTemplate;
    @SneakyThrows
    public boolean sendMessage(Message message)
    {
        this.kafkaTemplate.send(AppConstants.PRODUCER_TOPIC_NAME,message).get();
        return  true;
    }
}
