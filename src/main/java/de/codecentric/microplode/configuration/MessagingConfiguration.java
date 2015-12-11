package de.codecentric.microplode.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import de.codecentric.microplode.messaging.EventResultHandler;

@Configuration
@EnableRabbit
public class MessagingConfiguration implements RabbitListenerConfigurer {

    /*
     * Outbound Configuration
     */    
    @Bean
    public Queue queuePlayingField() {
        return new Queue(Queues.QUEUE_NAME_PLAYING_FIELD, false);
    }

    @Bean
    public Queue queueComputerPlayer() {
        return new Queue(Queues.QUEUE_NAME_COMPUTER_PLAYER, false);
    }
    
    @Bean
    public Queue queueGameService() {
        return new Queue(Queues.QUEUE_NAME_GAMESERVICE, false);
    }
    
    @Bean
    public Queue queuePresentationService() {
        return new Queue(Queues.QUEUE_NAME_PRESENTATION_SERVICE, false);
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(Queues.GENERAL_TOPIC_NAME);
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

    /*
     * Inbound Configuration
     * We are using Annotation-Driven-Message-Listening, described here
     * http://docs
     * .spring.io/spring-amqp/reference/htmlsingle/#async-annotation-driven
     */    
    @Autowired
    public ConnectionFactory connectionFactory;

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }

    @Bean
    public EventResultHandler eventResultHandler() {
        return new EventResultHandler();
    }

    @Override
    public void configureRabbitListeners(
            RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
    }

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(new MappingJackson2MessageConverter());
        return factory;
    }
}
