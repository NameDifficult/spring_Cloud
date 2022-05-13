package com.fu.springcloud.service.impl;

import com.fu.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 *   和rabbitMQ连接
 */
//指信道channel和交换机exchange绑定在一起
@EnableBinding(Source.class)//source：开启了输出源的推送管道
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;//消息发送管道


    /**
     * 通过output管道往消息中间件发送消息
     * @return
     */
    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("发送成功");
        return null;
    }
}
