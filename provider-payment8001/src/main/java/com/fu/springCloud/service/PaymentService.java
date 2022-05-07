package com.fu.springCloud.service;

import com.fu.springCloud.bean.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * 添加订单
     * @param payment
     * @return
     */
    public int createPayment(Payment payment);

    /**
     * 根据id查询订单信息
     * @param id
     * @return 返回订单信息
     */
    public Payment getPaymentById(@Param("id")Long id);
}
