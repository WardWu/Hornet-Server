package com.hornet.nest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * base控制层.
 *
 * @author: shengwu
 * @date: 2019/3/8
 */
@RestController
public class BaseController {

    @RequestMapping("/index")
    public String index() {
        return "Hello Spring Boot !";
    }

    @RequestMapping("/")
    public String start() {
        return "server start !!!";
    }
}
