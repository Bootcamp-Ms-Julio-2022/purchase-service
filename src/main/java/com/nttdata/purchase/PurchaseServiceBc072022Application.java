package com.nttdata.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class PurchaseServiceBc072022Application {

    public static void main(String[] args) {
        SpringApplication.run(PurchaseServiceBc072022Application.class, args);
    }

}
