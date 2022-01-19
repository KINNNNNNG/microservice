package com.example.simpleconsumermoviefeign.feignclient;

import com.example.simpleconsumermoviefeign.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Wk
 * @version 1.0
 * @date 2022/1/19 22:34
 */
@FeignClient(name = "provider-user")
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

}
