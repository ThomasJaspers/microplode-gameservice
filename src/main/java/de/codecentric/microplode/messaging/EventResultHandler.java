package de.codecentric.microplode.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import de.codecentric.microplode.configuration.Queues;
import de.codecentric.microplode.controller.GameServiceController;
import de.codecentric.microplode.messaging.api.Event;
import de.codecentric.microplode.messaging.api.EventType;

@Component
public class EventResultHandler {

    @Autowired
    private GameServiceController gameServiceController;
    
    @RabbitListener(queues=Queues.QUEUE_NAME_PRESENTATION_SERVICE)
    public void handleMessage(@Payload Event event) {
        System.out.println("Event received");
        System.out.println("EventType: " + event.getType().getText());
        
        if(EventType.NEW_GAME_EVENT.equals(event.getType())) {
            gameServiceController.startNewGame(event);
        }
    }
}
