package org.mba.clientservice;

import org.mba.clientservice.entities.Client;
import org.mba.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientServiceApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository) {
        return args -> {
            for(int i = 1 ; i <= 5 ; i++){
                Client client = Client.builder()
                        .name("name"+i)
                        .email("name"+i+"@mail.com")
                        .phone("06"+i+""+i+""+i+""+i+""+i+""+i+""+i)
                        .build();
                clientRepository.save(client);
            }
        };
    }
}
