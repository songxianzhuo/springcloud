package com.example.provideruser.dao;

import com.example.provideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述
 *
 * @author Song Xianzhuo
 * @version 1.0.0
 * @since 2020/06/29
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
