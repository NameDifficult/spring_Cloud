package com.fu.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//用于向使用consul和zookeeper作为注册中心时注册服务
public class Main8004 {
    public static void main(String[] args) {
        SpringApplication.run(Main8004.class,args);
    }
}
