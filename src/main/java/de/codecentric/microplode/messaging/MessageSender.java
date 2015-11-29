package de.codecentric.microplode.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.codecentric.microplode.configuration.MessagingConfiguration;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private MessageConverter jsonMessageConverter;

    public void sendMessage(Object msg) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend(MessagingConfiguration.QUEUE_NAME_COMPUTER_PLAYER, msg);
        rabbitTemplate.convertAndSend(MessagingConfiguration.QUEUE_NAME_PLAYING_FIELD, msg);
    }
}
