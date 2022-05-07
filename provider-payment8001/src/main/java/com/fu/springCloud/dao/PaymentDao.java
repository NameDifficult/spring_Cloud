package com.fu.springCloud.dao;

import com.fu.springCloud.bean.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
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
