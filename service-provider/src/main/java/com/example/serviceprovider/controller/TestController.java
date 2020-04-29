package com.example.serviceprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/04/29
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public Object hello(@RequestParam String name){
        System.out.println(name);
        return "hello " + name;
    }
}
