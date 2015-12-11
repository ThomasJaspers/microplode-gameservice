package de.codecentric.microplode.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.microplode.controller.GameServiceController;
import de.codecentric.microplode.messaging.api.EventBuilder;

@RestController
@RequestMapping("/gameservice")
public class GameServiceRestEndpoints {

    @Autowired
    private GameServiceController gameServiceController;

    @RequestMapping(value="/trigger-action", method=RequestMethod.GET)
    public @ResponseBody String triggerAction() {
        return gameServiceController.triggerAction();
    }
    
    @RequestMapping(value="/start-new-game", method=RequestMethod.GET)
    public @ResponseBody String startNewGame() {
        return gameServiceController.startNewGame(EventBuilder.newGameEvent());
    }
}
