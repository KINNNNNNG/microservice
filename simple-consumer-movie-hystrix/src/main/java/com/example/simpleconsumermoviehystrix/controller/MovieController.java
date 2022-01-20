package com.example.simpleconsumermoviehystrix.controller;

import com.example.simpleconsumermoviehystrix.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

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


    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        User user = restTemplate.getForObject("http://provider-user/users/{id}",User.class,id);
        return user;
    }

    public User findByIdFallback(Long id,Throwable throwable) {
        log.error("进入回退方法",throwable);
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(0));
    }

}
