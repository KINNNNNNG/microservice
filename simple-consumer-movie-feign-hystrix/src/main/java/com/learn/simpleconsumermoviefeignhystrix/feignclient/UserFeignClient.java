package com.learn.simpleconsumermoviefeignhystrix.feignclient;

import com.learn.simpleconsumermoviefeignhystrix.model.User;
import feign.Logger;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Wk
 * @version 1.0
 * @date 2022/1/19 22:34
 */
@FeignClient(name = "provider-user",configuration = UserFeignConfig.class,fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);

    @PostMapping("/users/model")
    User findByModel(@RequestBody User user);
}

/**
 * 该Feign Client的配置类，注意：
 * 1. 该类可以独立出去；
 * 2. 该类上也可添加@Configuration声明是一个配置类；
 * 配置类上也可添加@Configuration注解，声明这是一个配置类；
 * 但此时千万别将该放置在主应用程序上下文@ComponentScan所扫描的包中，
 * 否则，该配置将会被所有Feign Client共享，无法实现细粒度配置！
 * 个人建议：像我一样，不加@Configuration注解
 *
 * @author zhouli
 */
class UserFeignConfig{
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}

/**
 * 提供fallBack
 */
@Component
class UserFeignClientFallback implements UserFeignClient{

    @Override
    public User findById(Long id) {
        return new User();
    }

    @Override
    public User findByModel(User user) {
        return new User();
    }
}

@Component
@Slf4j
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                log.error("进入回退：",throwable);
                return new User();
            }

            @Override
            public User findByModel(User user) {
                log.error("进入回退：",throwable);
                return new User();
            }
        };
    }
}
