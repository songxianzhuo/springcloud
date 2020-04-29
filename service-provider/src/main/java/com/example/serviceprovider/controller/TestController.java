package com.example.serviceprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/04/29
 **/
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/hello")
    public Object hello(){
        System.out.println(discoveryClient.description());
        // 根据serviceId获取服务实例列表
        List<ServiceInstance> list = discoveryClient.getInstances("hello-service");
        list.forEach(s ->{
            System.out.println("host:" + s.getHost() + " service_id:" + s.getServiceId());
        });
        return "hello,this is hello service";
    }

    @GetMapping("/hello")
    public Object hello(@RequestParam String name){
        System.out.println(name);
        return "hello " + name;
    }
}
