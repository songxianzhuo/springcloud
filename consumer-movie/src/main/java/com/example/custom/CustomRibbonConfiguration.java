package com.example.custom;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon客户端配置，这种配置是细粒度的，不同的Ribbon客户端可以使用不同的配置，另一种方式是在yml文件中进行属性配置
 * ribbon默认配置类是RibbonClientConfiguration
 * 注意: 此类不应该出现在主应用程序上下文的@ComponentScan扫描的包中，否则会覆盖所有ribbon客户端的默认配置
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@Configuration
public class CustomRibbonConfiguration {

    /**
     * 负载均衡策略
     * RandomRule：随机
     * RoundRobinRule: 线性轮询
     * RetryRule: 重试机制的实例选择功能
     * WeightResponseTimeRule：是RoundRobinRule的扩展，增加了根据实例的运行情况计算权重，并根据权重挑选实例
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }


}
