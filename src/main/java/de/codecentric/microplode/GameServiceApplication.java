package de.codecentric.microplode;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.codecentric.microplode.domain.Game;

@SpringBootApplication
public class GameServiceApplication  {

    final static String queueNamePlayingField = "microplode-newgame-event-playingfield";

    final static String queueNameComputerPlayer = "microplode-newgame-event-computerplayer";

    @Bean
    Queue queuePlayingField() {
        return new Queue(queueNamePlayingField, false);
    }

    @Bean
    Queue queueComputerPlayer() {
        return new Queue(queueNameComputerPlayer, false);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("microplode-topic-gameservice-exchange");
    }

    @Bean
    List<Binding> binding() {
        return Arrays.asList(BindingBuilder.bind(queuePlayingField()).to(exchange()),
                BindingBuilder.bind(queueComputerPlayer()).to(exchange()));
    }

    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }
    
    @Bean
    public Game game() {
        return new Game();
    }
}
