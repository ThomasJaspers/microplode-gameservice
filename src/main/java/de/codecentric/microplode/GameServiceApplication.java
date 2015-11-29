package de.codecentric.microplode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.codecentric.microplode")
public class GameServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }
}
