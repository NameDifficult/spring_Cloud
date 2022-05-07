package com.fu.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Main8006 {
    public static void main(String[] args) {
        SpringApplication.run(Main8006.class,args);
    }
}
