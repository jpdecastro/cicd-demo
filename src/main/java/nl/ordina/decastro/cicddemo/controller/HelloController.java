package nl.ordina.decastro.cicddemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/greet")
    public String sayHello(@RequestParam(value = "name", defaultValue = "dewd") String name) {
        return "Hi there " + name + ", what can I do for you?";
    }

}
