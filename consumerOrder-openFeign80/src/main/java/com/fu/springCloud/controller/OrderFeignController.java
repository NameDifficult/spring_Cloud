package com.fu.springCloud.controller;

import com.fu.springCloud.bean.CommonResult;
import com.fu.springCloud.bean.Payment;
import com.fu.springCloud.sevice.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * openfeign调用流程： controller层 ->  service层，根据service层Mapping地址  ->   8001服务端controller地址
 *
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/getPaymentBayId/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);

    }
}
