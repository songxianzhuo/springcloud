package com.example.provideruser.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private BigDecimal balance;
}
