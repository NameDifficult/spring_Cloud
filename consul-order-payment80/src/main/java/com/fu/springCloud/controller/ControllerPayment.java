package com.fu.springCloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ControllerPayment {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consul/payment")
    public String paymentConsul(){
        return restTemplate.getForObject("http://consul-provider-payment/consul/payment",String.class);
    }
}
