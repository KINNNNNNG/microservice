package com.learn.simpleprovideruser.controller;

import com.learn.simpleprovideruser.dao.UserRepository;
import com.learn.simpleprovideruser.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author: WangKai
 * @create: 2022/01/19 15:57
 **/
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @RequestMapping("/model")
    public User findByModel(@RequestBody User user) {
        if (user.getAge() != null) {
            user.setAge(user.getAge() + 1);
        } else {
            user.setAge(Double.valueOf(Math.random()*100).intValue());
        }
        return user;
    }
}
