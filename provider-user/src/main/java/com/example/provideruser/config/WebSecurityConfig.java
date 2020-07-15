//package com.example.provideruser.config;
//
//import com.example.provideruser.service.CustomUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * 描述
// *
// * @author Song Xianzhuo
// * @version 1.0.0
// * @since 2020/07/01
// **/
//@Configuration
////@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 所有请求都要经过httpbasic认证
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailService);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // 明文编码器。这是一个不做任何操作的密码编码器，是Spring提供给我们做明文测试的。
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//
//}
