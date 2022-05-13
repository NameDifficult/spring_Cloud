package com.fu.springCloud.controller;

import com.fu.springCloud.bean.CommonResult;
import com.fu.springCloud.bean.Payment;
import com.fu.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //获取端口
    @Value("${server.port}")
    private String serverPort;

    //服务信息
    @Resource
    private DiscoveryClient discoveryClient;


    /**
     *  保存
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.createPayment(payment);
        log.info("****插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,端口号："+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }


    @GetMapping("/payment/getPaymentBayId/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果："+payment);
        if (payment!=null){
            return new CommonResult(200,"查询成功,端口号："+serverPort,payment);
        }else {
            return new CommonResult(444,"查询ID不存在",null);
        }
    }


    /*
     * 自测服务发现
     * 可以知道eureka中有几个服务，各服务的信息
     * 需要DiscoveryClient，还需要在启动类中标注@EnableDiscoveryClient
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services){
            log.info("****element:"+ element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }




    /**
     * 测试zipkin
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
