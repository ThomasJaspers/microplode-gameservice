package de.codecentric.microplode.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    final static String queueName = "microplode-topic";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(queueName, msg);
    }
}
