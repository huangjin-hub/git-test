package com.jin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.Arrays;

@EnableConfigServer
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Start {

    public static void main(String[] args) {

        SpringApplication.run(Start.class, args);
    }
}
