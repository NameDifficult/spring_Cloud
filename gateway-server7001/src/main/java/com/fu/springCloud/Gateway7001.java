package com.fu.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //表示是eureka注册中心
public class Gateway7001 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway7001.class,args);
    }
}
