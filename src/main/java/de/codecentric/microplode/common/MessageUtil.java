package de.codecentric.microplode.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageUtil {

    private MessageUtil() {};
    
    public static void printJson2Console(Object event) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("Event: " + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(event));
        } catch (JsonProcessingException e) {
            System.out.println("Event-Debugging didn´t work: " + e.getLocalizedMessage());
        }
    }
}
