package com.learn.simpleconsumermovieribbon.controller;

import com.learn.simpleconsumermovieribbon.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: WangKai
 * @create: 2022/01/19 16:22
 **/
@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User user = restTemplate.getForObject("http://provider-user/users/{id}",User.class,id);
        log.info("ribbon2:{}",user);
        return user;
    }
}
