package me.kanggara.restful.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TestController {
    @GetMapping
    public String welcome(){
        return "Hello world!";
    }

    @PostMapping
    public String other(){
        return "This Is POST Method";
    }
}
