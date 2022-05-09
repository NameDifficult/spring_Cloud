package com.fu.springCloud.service;


import org.springframework.stereotype.Component;

/**
 * 当调用OrderHystrixService中的方法发生异常需要降级时，就找到这个类中的方法来进行fallback
 */
@Component
public class OrderFallbackService implements OrderHystrixService{
    @Override
    public String payment_OK(Integer id) {
        return "服务调用失败，提示来自：payment_OK";
    }

    @Override
    public String payment_timeOut(Integer id) {
        return "服务调用失败，提示来自：payment_timeOut";
    }
}
