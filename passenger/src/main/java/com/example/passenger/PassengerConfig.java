package com.example.passenger;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PassengerConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PassengerRepository repository
    )
    {
        return args -> {
            Passenger halid = new Passenger(
                    "Halid",
                    "Merdic",
                    1L,
                    "halid-merdic@hotmail.com"
            );
            Passenger kralj = new Passenger(
                    "Kralj",
                    "Kraljevic",
                    2L,
                    "kralj-kraljevic@hotmail.com"
            );

            repository.saveAll(
                    List.of(halid, kralj)
            );
        };
    }
}

