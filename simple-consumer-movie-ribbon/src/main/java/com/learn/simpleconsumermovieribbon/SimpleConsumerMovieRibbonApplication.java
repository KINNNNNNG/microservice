package com.learn.simpleconsumermovieribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SimpleConsumerMovieRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleConsumerMovieRibbonApplication.class, args);
    }

    /**
     * {@link LoadBalanced} RestTemplate整合Ribbon
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
