package com.jiniubao.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jiniubao.demo.entity.App;
import com.jiniubao.demo.mapper.AppMapper;

@RestController
public class HelloController {
    private final AppMapper appMapper;

    public HelloController(AppMapper appMapper) {
        this.appMapper = appMapper;
    }

    @GetMapping("/hello/sql")
    public App getAppData() {
        return appMapper.findPcJiniubaoApp();
    }

    @GetMapping("/hello")
    public String hello() {
        return "world";
    }

    @GetMapping("/hello/json")
    public ApiResponse helloJson() {
        return new ApiResponse(new HelloData("world"));
    }

    // 内部类必须放在控制器类内部
    private static class ApiResponse {
        private HelloData data;
        public ApiResponse(HelloData data) {
            this.data = data;
        }
        public HelloData getData() {
            return this.data;
        }
    }

    private static class HelloData {
        private String hello;
        public HelloData(String value) {
            this.hello = value;
        }
        public String getHello() {
            return this.hello;
        }
    }
}