package com.fu.springCloud.controller;

import com.fu.springCloud.bean.CommonResult;
import com.fu.springCloud.bean.Payment;
import com.fu.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //获取端口
    @Value("${server.port}")
    private String serverPort;

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

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }
}
