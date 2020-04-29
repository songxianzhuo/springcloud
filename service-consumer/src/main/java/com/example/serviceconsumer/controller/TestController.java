package com.example.serviceconsumer.controller;

import com.example.serviceconsumer.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/04/29
 **/
@RestController
public class TestController {

    @Resource
    HelloService helloService;

    @GetMapping("/hello1")
    public Object hello1(@RequestParam String name){
        System.out.println(name);
        return helloService.hello(name);
    }
}
