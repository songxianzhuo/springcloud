package com.example.consumermovie2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@NoArgsConstructor
@Data
public class User {

    private long id;

    private String username;

    private String name;

    private int age;

    private BigDecimal balance;
}
