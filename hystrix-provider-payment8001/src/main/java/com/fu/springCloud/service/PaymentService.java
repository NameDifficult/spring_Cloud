package com.fu.springCloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentService {
    /**
     *  正常执行
     * @param id
     * @return
     */
    public String payment_OK(Integer id){
        return "线程池" + Thread.currentThread().getName() + "  payment_OK; id="+id;
    }


    /**
     *      一般设在客户端80出
     *      超时错误  超时异常，计算异常(10/0)等
     *      发生错误后fallback指定方法
     */
//    @HystrixCommand(fallbackMethod = "payment_timeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String payment_timeOut(Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "  payment_timeOut; id="+id;
    }
    //错误后要fallback的方法
//    public String payment_timeOutHandler(Integer id){
//
//        return "线程池" + Thread.currentThread().getName() + "  OUT; id="+id;
//    }





    //-----服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期:熔断后10秒后尝试恢复
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//10次中失败率达到多少后开启熔断
    })
    public String paymentCircuitBreaker(Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
