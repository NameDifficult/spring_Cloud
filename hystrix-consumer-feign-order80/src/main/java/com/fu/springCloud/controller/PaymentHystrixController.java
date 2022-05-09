package com.fu.springCloud.controller;

import com.fu.springCloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")//hystrix类上全局配置，默认fallback的方法
public class PaymentHystrixController {
    @Resource
    private OrderHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String payment_OK(@PathVariable("id")Integer id){
        return paymentHystrixService.payment_OK(id);
    }





    @GetMapping("/payment/hystrix/timeOut/{id}")
//    @HystrixCommand(fallbackMethod = "payment_timeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand //没有特意指定，使用默认的。    上面是指定了
    public String payment_timeOut(@PathVariable("id") Integer id){
        return paymentHystrixService.payment_timeOut(id);
    }
    //错误后要fallback的方法
    public String payment_timeOutHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + "  80OUT; id="+id;
    }



    //全局fallback
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
