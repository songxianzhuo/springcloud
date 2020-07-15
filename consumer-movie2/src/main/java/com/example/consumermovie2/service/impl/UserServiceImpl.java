package com.example.consumermovie2.service.impl;


import com.example.consumermovie2.entity.User;
import com.example.consumermovie2.service.IUserService;
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
        return null;
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
