package com.example.week02_work6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2021-03-27 15:35
 * @Modified By：
 */
@SpringBootApplication
@RestController
public class Week02Work6Application {
    public static void main(String[] args) {
        SpringApplication.run(Week02Work6Application.class, args);
    }

    @GetMapping()
    public String hello(){
        return "hello";
    }
}
