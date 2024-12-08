package org.mba.saleservice;

import org.mba.saleservice.entities.Sale;
import org.mba.saleservice.repositories.SaleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
@EnableFeignClients
@SpringBootApplication
public class SaleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(SaleRepository saleRepository) {
        return args -> {
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    Sale sale = new Sale();
                    sale.setIdp(i);
                    sale.setIdc(j);
                    sale.setDate(new Date());
                    saleRepository.save(sale);
                }
            }
        };
    }
}
