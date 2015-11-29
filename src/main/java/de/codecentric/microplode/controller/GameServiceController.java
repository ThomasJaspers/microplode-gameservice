package de.codecentric.microplode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.codecentric.microplode.domain.Game;
import de.codecentric.microplode.messaging.MessageSender;
import de.codecentric.microplode.messaging.api.Event;
import de.codecentric.microplode.messaging.api.EventType;
import de.codecentric.microplode.messaging.api.PlayerDef;
import de.codecentric.microplode.messaging.api.PlayerType;


@RestController
@RequestMapping("/gameservice")
public class GameServiceController {

    @Autowired
    private MessageSender messageSender;
    
    @Autowired
    private Game game;

    @RequestMapping(value="/trigger-action", method=RequestMethod.GET)
    public @ResponseBody String triggerAction() throws Exception{
        messageSender.sendMessage("Trigger Action");
        return "TriggerAction Called";
    }
    
    @RequestMapping(value="/start-new-game", method=RequestMethod.GET)
    public @ResponseBody String startNewGame() throws Exception {
        game.setStarted(true);
        
        Event newGameEvent = buildEvent();
        
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Event: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newGameEvent));
        
        messageSender.sendMessage(newGameEvent);
        
        return "Games started";
    }

    private Event buildEvent() {
        Event newGameEvent = new Event();
        newGameEvent.setType(EventType.NEW_GAME);
        PlayerDef playerOne = new PlayerDef();
        playerOne.setId("Kurt");
        playerOne.setType(PlayerType.HUMAN);
        newGameEvent.addPlayers(playerOne);
        
        PlayerDef playerTwo = new PlayerDef();
        playerTwo.setId("HighEndMac");
        playerTwo.setType(PlayerType.COMPUTER);
        newGameEvent.addPlayers(playerTwo);
        return newGameEvent;
    }
}