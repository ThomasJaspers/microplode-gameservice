package de.codecentric.microplode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import de.codecentric.microplode.configuration.Queues;
import de.codecentric.microplode.domain.Game;
import de.codecentric.microplode.messaging.MessageSender;
import de.codecentric.microplode.messaging.api.Event;


@Controller
public class GameServiceController {

    @Autowired
    private MessageSender messageSender;
    
    @Autowired
    private Game game;

    public String triggerAction() {
        messageSender.sendMessage(Queues.GENERAL_TOPIC_NAME, "Trigger Action");
        return "TriggerAction Called";
    }
    
    public String startNewGame(Event newGameEvent) {
        game.setStarted(true);
        
        messageSender.sendMessage(Queues.QUEUE_NAME_COMPUTER_PLAYER, newGameEvent);
        messageSender.sendMessage(Queues.QUEUE_NAME_PLAYING_FIELD, newGameEvent);
        
        return "Game started";
    }


}