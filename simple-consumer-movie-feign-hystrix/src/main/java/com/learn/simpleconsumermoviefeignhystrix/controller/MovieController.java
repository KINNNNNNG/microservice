package com.learn.simpleconsumermoviefeignhystrix.controller;

import com.learn.simpleconsumermoviefeignhystrix.feignclient.UserFeignClient;
import com.learn.simpleconsumermoviefeignhystrix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: WangKai
 * @create: 2022/01/19 16:22
 **/
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User user = userFeignClient.findById(id);
        return user;
    }

    @GetMapping("/users/model")
    public User findByModel() {
        User user = new User();
        user.setId(2L);
        user.setUsername("李四");
        return userFeignClient.findByModel(user);
    }
}
