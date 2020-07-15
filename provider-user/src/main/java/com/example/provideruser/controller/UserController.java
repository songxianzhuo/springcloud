package com.example.provideruser.controller;
import java.math.BigDecimal;

import com.example.provideruser.dao.UserRepository;
//import com.example.provideruser.entity.SecurityUser;
import com.example.provideruser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User one = userRepository.findById(id).get();
        return one;
    }

    /**
     * 接口认证
     */
//    @GetMapping("/security/{id}")
//    public User findById2(@PathVariable Long id) throws Exception {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof UserDetails){
//            UserDetails userDetails = (SecurityUser)principal;
//            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//            for (GrantedAuthority authority : authorities) {
//                // 打印当前用户信息
//                System.out.println("当前用户：" + userDetails.getUsername() + " 角色是：" + authority.getAuthority());
//            }
//        }else{
//            throw new Exception("无权限访问");
//        }
//        User one = userRepository.findById(id).get();
//        return one;
//    }

    /**
     * 多参数get请求
     * @param id
     * @param username
     * @return
     */
    @GetMapping("/multiParams")
    public User multiParams(@RequestParam Long id,@RequestParam String username){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setName("zhangyao");
        user.setAge(0);
        user.setBalance(new BigDecimal("0"));
        return user;
    }

    /**
     * 客户端负载均衡
     */
    @GetMapping("/loadBalanceInstance")
    public void loadBalanceInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("consumer-movie");
        System.out.println("serviceId:" + serviceInstance.getServiceId() + " host:" + serviceInstance.getHost() + " port:" + serviceInstance.getPort());
    }
}
