package com.buzas.discoveryclientdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories("com.buzas.discoveryclientdb.items")
public class DiscoveryClientDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryClientDbApplication.class, args);
    }

}
