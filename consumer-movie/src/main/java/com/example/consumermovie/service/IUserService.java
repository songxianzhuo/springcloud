package com.example.consumermovie.service;

import com.example.consumermovie.config.feign.FeignClientFallbackFactory;
import com.example.consumermovie.entity.User;
import com.example.consumermovie.service.impl.UserServiceImpl;
import com.example.custom.CustomFeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Feign是Netflix开发的声明式、模块化的http客户端
 * Spring Cloud对Feign进行的增强，使其支持了SpringMVC注解,如@RequestMapping、@ReuqestParam、@PathVariable、@RequestBody、@GETMapping、@POSTMapping等
 * @FeignClient注解
 *  作用：通知Feign组件对该接口进行代理(不需要编写接口实现)，使用者可直接通过@Autowired注入
 *  常用属性
 *      name：服务名，用于创建Ribbon负载均衡器
 *      url：用于指定请求的url
 *      configuration：用于指定Feign的配置类,可以为每个Feign客户端自定义配置
 *      fallback：整合Hystrix的断路器，指定回退类，回退类需实现FeignClient接口,前提是Feign需要开启hystrix支持
 *      fallbackFactory: 指定fallbackFactory类，用于检查回退原因,和fallback主要区别是打印回退原因，两者二选一,不能同时使用
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@FeignClient(name = "provider-user",
//        fallback = UserServiceImpl.class
        configuration = CustomFeignConfiguration.class,
        fallbackFactory = FeignClientFallbackFactory.class
        )
public interface IUserService {

    /**
     * 使用SpringMvc注解，默认
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    User findById(@PathVariable long id);

    /**
     * 访问需要认证的接口
     * @param id
     * @return
     */
    @GetMapping("/security/{id}")
    User findById2(@PathVariable long id);

    /**
     * Get请求多参数方法一
     * @param id
     * @param username
     * @return
     */
    @GetMapping("/multiParams")
    User multiParams(@RequestParam Long id,@RequestParam String username);

    /**
     * Get请求多参数方法二
     * @param map
     * @return
     */
    @GetMapping("/multiParams")
    User multiParams(@RequestParam Map<String,Object> map);

//    /**
//     * 使用Feign原生注解，需配置
//     * @param id
//     * @return
//     */
//    @RequestLine("GET /{id}")
//    User findById(@Param("id") long id);
}
