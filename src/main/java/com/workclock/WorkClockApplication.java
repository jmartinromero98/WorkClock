package com.workclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.example.infrastructure"})
public class WorkClockApplication {

    public static void main(String[] args) {
        System.out.println("Hola!");
        SpringApplication.run(WorkClockApplication.class, args);
    }
}
