package com.question.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.question.**.feign"})
public class QuestionCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionCenterServiceApplication.class, args);
    }

}
