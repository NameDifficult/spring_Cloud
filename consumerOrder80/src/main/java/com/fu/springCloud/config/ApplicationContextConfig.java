package com.fu.springCloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
//    @LoadBalanced//赋予RestTemplate负载均衡的能力。才能通过微服务名称访问服务器
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
