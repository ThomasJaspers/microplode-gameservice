package de.codecentric.microplode.controller;

import de.codecentric.microplode.messaging.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/trigger-action")
public class TriggerActionController {

    @Autowired
    private MessageSender messageSender;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String triggerAction() throws Exception{
        messageSender.sendMessage("Trigger Action");
        return "TriggerAction Called";
    }
}