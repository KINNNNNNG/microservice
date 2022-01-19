package com.learn.simpleprovideruser.dao;

import com.learn.simpleprovideruser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: WangKai
 * @create: 2022/01/19 15:56
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
