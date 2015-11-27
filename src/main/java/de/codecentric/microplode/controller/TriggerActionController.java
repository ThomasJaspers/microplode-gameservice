package de.codecentric.microplode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.microplode.domain.Game;
import de.codecentric.microplode.messaging.MessageSender;


@RestController
@RequestMapping("/gameservice")
public class TriggerActionController {

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
    public @ResponseBody String startNewGame() {
        game.setStarted(true);
        return "Games started";
    }
}