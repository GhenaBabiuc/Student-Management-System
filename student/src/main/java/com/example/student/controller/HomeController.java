package com.example.student.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping()
    public String homeMethod() {
        return "Home";
    }

    @GetMapping("/param")
    public String homeMethodRequestParam(@RequestParam String paramValue) {
        return "Home with Param";
    }

    @GetMapping("/hello/{name}")
    public String helloMethod(@PathVariable String name, @RequestParam String version, @RequestParam String altParam) {
        return "Hello " + name + ". Version =  " + version + " Alt param = " + altParam;
    }

    @PostMapping("/hi")
    public String hiMethod(@RequestBody String name) {
        return "Hi " + name;
    }

}