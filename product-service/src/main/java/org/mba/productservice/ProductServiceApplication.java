package org.mba.productservice;

import org.mba.productservice.entities.Product;
import org.mba.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
           for(int i = 1 ; i <= 5 ; i++ ){
               Product product = Product.builder()
                       .name("name"+i)
                       .description("description"+i)
                       .price(i*100)
                       .build();
               productRepository.save(product);
           }
        };
    }
}
