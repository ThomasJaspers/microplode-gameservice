package de.codecentric.microplode;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
import java.util.List;

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
}
