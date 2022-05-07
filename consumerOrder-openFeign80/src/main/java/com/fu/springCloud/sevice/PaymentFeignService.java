package com.fu.springCloud.sevice;

import com.fu.springCloud.bean.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")//微服务名称
public interface PaymentFeignService {
    @GetMapping("/payment/getPaymentBayId/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);
}
