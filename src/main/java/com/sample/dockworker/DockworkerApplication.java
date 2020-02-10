package com.sample.dockworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
public class DockworkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockworkerApplication.class, args);
    }

}
