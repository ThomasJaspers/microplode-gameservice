package de.codecentric.microplode.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    public static final String GENERAL_TOPIC_NAME = "microplode-topic-gameservice-exchange";
    public static final String QUEUE_NAME_PLAYING_FIELD = "microplode-newgame-event-playingfield";
    public static final String QUEUE_NAME_COMPUTER_PLAYER = "microplode-newgame-event-computerplayer";

    @Bean
    public Queue queuePlayingField() {
        return new Queue(QUEUE_NAME_PLAYING_FIELD, false);
    }

    @Bean
    public Queue queueComputerPlayer() {
        return new Queue(QUEUE_NAME_COMPUTER_PLAYER, false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(GENERAL_TOPIC_NAME);
    }

    @Bean
    public List<Binding> binding() {
        return Arrays.asList(
                BindingBuilder.bind(queuePlayingField()).to(exchange()),
                BindingBuilder.bind(queueComputerPlayer()).to(exchange()));
    }
    
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
