package com.fu.springCloud.controller;

import com.fu.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id")Integer id){
        String s = paymentService.payment_OK(id);
        log.info("*********result:"+s);
        return s;
    }


    @GetMapping("/payment/hystrix/timeOut/{id}")
    public String payment_timeOut(@PathVariable("id") Integer id){
        String s = paymentService.payment_timeOut(id);
        log.info("*********result:"+s);
        return s;
    }


    //----服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }


}
