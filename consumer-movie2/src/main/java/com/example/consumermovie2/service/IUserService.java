package com.example.consumermovie2.service;


import com.example.consumermovie2.entity.User;
import com.example.consumermovie2.service.impl.UserServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@FeignClient(name = "provider-user",
        fallback = UserServiceImpl.class
        )
public interface IUserService {

    /**
     * 使用SpringMvc注解，默认
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    User findById(@PathVariable("id") long id);

    /**
     * Get请求多参数方法一
     * @param id
     * @param username
     * @return
     */
    @GetMapping("/multiParams")
    User multiParams(@RequestParam Long id, @RequestParam String username);

    /**
     * Get请求多参数方法二
     * @param map
     * @return
     */
    @GetMapping("/multiParams")
    User multiParams(@RequestParam Map<String, Object> map);

}
