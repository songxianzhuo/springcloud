package com.example.consumermovie2.controller;

import com.example.consumermovie2.entity.User;
import com.example.consumermovie2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@RestController
public class MovieController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private IUserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userService.findById(id);
    }


    @GetMapping("/multiParams/{id}")
    public User multiParams(@PathVariable Long id, @RequestParam String username){
        return userService.multiParams(id,username);
    }

    @GetMapping("/multiParams2/{id}")
    public User multiParams2(@PathVariable Long id, @RequestParam String username){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        return userService.multiParams(map);
    }

    /**
     * 获取privoder-user服务的所有实例信息
     * @return
     */
    @GetMapping("/showInstanceInfo")
    public List<ServiceInstance> showInstanceInfo(){
        return discoveryClient.getInstances("provider-user");
    }

    /**
     * 客户端负载均衡
     */
    @GetMapping("/loadBalanceInstance")
    public void loadBalanceInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-user");
        System.out.println("serviceId:" + serviceInstance.getServiceId() + " host:" + serviceInstance.getHost() + " port:" + serviceInstance.getPort());
    }



}
