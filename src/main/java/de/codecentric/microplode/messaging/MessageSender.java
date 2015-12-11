package de.codecentric.microplode.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.codecentric.microplode.common.MessageUtil;
import de.codecentric.microplode.configuration.MessagingConfiguration;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private MessageConverter jsonMessageConverter;

    public void sendMessage(String queueName, Object msg) {
        System.out.println("Sending message...");
        MessageUtil.printJson2Console(msg);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        rabbitTemplate.convertAndSend(queueName, msg);
    }
    
    
}
