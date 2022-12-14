package com.example.springredisexample4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringRedisExample4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisExample4Application.class, args);
    }

}
