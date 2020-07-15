package com.example.consumermovie.config.ribbon;

import com.example.custom.CustomRibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@RibbonClient注解为特定name的RibbonClient自定义配置
 * name：服务名
 * configuration：配置类
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@Configuration
@RibbonClient(name = "provider-user",configuration = CustomRibbonConfiguration.class)
public class TestCustomRibbonConfiguration {
}
