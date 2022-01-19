package com.learn.simpleconsumermoviefeign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author: WangKai
 * @create: 2022/01/19 16:21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;
}

