package com.example.consumermovie.service.impl;

import com.example.consumermovie.entity.User;
import com.example.consumermovie.service.IUserService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 描述 FeignClient的回退类
 * 回退类一般返回的是默认值
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@Component
public class UserServiceImpl implements IUserService {
    @Override
    public User findById(long id) {
        User user = new User();
        user.setId(10000);
        user.setUsername("songxianzhuo");
        user.setName("zhangyao");
        user.setAge(30);
        user.setBalance(new BigDecimal("1000.00"));
        return user;
    }

    @Override
    public User findById2(long id) {
        User user = new User();
        user.setId(10000);
        user.setUsername("songxianzhuo");
        user.setName("zhangyao");
        user.setAge(30);
        user.setBalance(new BigDecimal("1000.00"));
        return user;
    }

    @Override
    public User multiParams(Long id, String username) {
        return null;
    }

    @Override
    public User multiParams(Map<String, Object> map) {
        return null;
    }
}
