package de.codecentric.microplode.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.codecentric.microplode.controller.GameServiceController;
import de.codecentric.microplode.domain.Game;

@Configuration
public class GameServiceConfiguration {
    
    @Bean
    public GameServiceController gameServiceController() {
        return new GameServiceController();
    }
    
    @Bean
    public Game game() {
        return new Game();
    }
}
