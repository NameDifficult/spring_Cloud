package com.fu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Main3344 {
    public static void main(String[] args) {
        SpringApplication.run(Main3344.class,args);
    }
}
