package de.codecentric.microplode.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    final static String queueNamePlayingField = "microplode-newgame-event-playingfield";

    final static String queueNameComputerPlayer = "microplode-newgame-event-computerplayer";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(queueNameComputerPlayer, msg);
        rabbitTemplate.convertAndSend(queueNamePlayingField, msg);
    }
}
