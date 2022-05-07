package com.fu.springCloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *  获取注册中心的机器信息
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
