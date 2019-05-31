package com.hornet.nest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * base控制层.
 * Author： shengwu
 * DATE ：  2019/2/13
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
