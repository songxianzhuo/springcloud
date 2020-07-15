package com.example.custom;

import feign.Contract;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.Log;

/**
 * 自定义FeignClient配置类，这种配置是细粒度的，不同的Feign客户端可以使用不同的配置
 * Feign的默认配置类是FeignClientsConfiguration类
 * 注意: 此类不应该出现在主应用程序上下文的@ComponentScan扫描的包中，否则会覆盖所有ribbon客户端的默认配置
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/07/01
 **/
@Configuration
public class CustomFeignConfiguration {
    /**
     * 使用Feign原生注解
     * Feign默认使用的契约是SpringMvcContract，即支持使用springmvc的注解
     * @return
     */
//    @Bean
//    public Contract feignContract(){
//        return new feign.Contract.Default();
//    }

    /**
     * 设置Feign的日志打印，Feign的Logger.Level只对debug模式做出响应
     * NONE:不记录任何日志
     * BASIC：仅记录请求方法、URL、响应状态码以及执行时间
     * HEADERS：在BASIC的基础上，记录请求和响应的haeder
     * FULL：记录请求和响应的header、body和元数据
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
