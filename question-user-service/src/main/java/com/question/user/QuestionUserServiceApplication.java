package com.question.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.question.**.feign"})
@EnableDiscoveryClient
public class QuestionUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionUserServiceApplication.class, args);
    }

}
