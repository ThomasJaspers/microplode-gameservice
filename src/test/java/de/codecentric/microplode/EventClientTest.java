package de.codecentric.microplode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.codecentric.microplode.configuration.Queues;
import de.codecentric.microplode.domain.Game;
import de.codecentric.microplode.messaging.MessageSender;
import de.codecentric.microplode.messaging.api.Event;
import de.codecentric.microplode.messaging.api.EventBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=GameServiceApplication.class)
public class EventClientTest {

    @Autowired
    private MessageSender messageSender;
    
    @Autowired
    private Game game;
    
    @Test
    public void newGameEventTest() {
        // Given
        Event newGameEvent = EventBuilder.newGameEvent();
        
        // When
        messageSender.sendMessage(Queues.QUEUE_NAME_GAMESERVICE, newGameEvent);
        
        // Then
        assertTrue("the Game should be in started mode", game.isStarted());
    }
}
