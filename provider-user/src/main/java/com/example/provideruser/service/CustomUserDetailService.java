//package com.example.provideruser.service;
//
//import com.example.provideruser.entity.SecurityUser;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// * 描述
// *
// * @author Song Xianzhuo
// * @version 1.0.0
// * @since 2020/07/01
// **/
//@Component
//public class CustomUserDetailService implements UserDetailsService {
//
//    /**
//     * 模拟两个账户：
//     * 账号1是user，密码是password1，角色是user-role
//     * 账号2是admin，密码是password2，角色是admin-role
//     */
//    @Override
//    public UserDetails loadUserByUsername(String usename) throws UsernameNotFoundException {
//        if("user".equals(usename)){
//            return new SecurityUser("user","password1","user-role");
//        }else if ("admin".equals(usename)){
//            return new SecurityUser("admin","password2","admin-role");
//        }else {
//            return null;
//        }
//    }
//}
