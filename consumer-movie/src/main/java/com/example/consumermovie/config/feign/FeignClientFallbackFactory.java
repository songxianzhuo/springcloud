package com.example.consumermovie.config.feign;

import com.example.consumermovie.entity.User;
import com.example.consumermovie.service.IUserService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 描述 IUserService代表的FeignClient的fallbackFactory类，用于检查回退原因
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/07/01
 **/
@Component
public class FeignClientFallbackFactory implements FallbackFactory<IUserService> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    /**
     * 重写create方法
     * @param throwable
     * @return
     */
    @Override
    public IUserService create(Throwable throwable) {
        //一进入异常就能知道什么异常
        FeignClientFallbackFactory.LOGGER.info("fallback-异常: {}", throwable.toString());
        FeignClientFallbackFactory.LOGGER.info("fallback-原因: {}", throwable.getMessage());
        return new IUserService() {
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
        };
    }
}
