package com.example.secondspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/user")
public class HelloController {

    @GetMapping("/greet")
    public String getGreetings(){
        return "Hello";
    }
    @GetMapping("/name")
    public String getName(){
        return "Ram";
    }
}
