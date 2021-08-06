package com.yqz.swaggerdemo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/yqz/test")
    public String hello1(){
        return "test";
    }



}
