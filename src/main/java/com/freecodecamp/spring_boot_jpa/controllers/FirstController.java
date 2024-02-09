package com.freecodecamp.spring_boot_jpa.controllers;

import static java.lang.StringTemplate.STR;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.freecodecamp.spring_boot_jpa.dtos.OrderDto;
import com.freecodecamp.spring_boot_jpa.dtos.records.OrderRecord;

@RestController
public class FirstController {

    // ^ RequestMappingHandlerMapping is the class that maps these URI to the
    // corrispondent
    // ^ handler method at the boostrapping of Spring App
    @GetMapping("/helloWorld")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("postMessage")
    @ResponseStatus(HttpStatus.CREATED)
    public String postMessage(@RequestBody Map<String, String> payload) {
        String message = payload.get("message");
        return STR."Request accepted, the message is \{message}";
    }

    @PostMapping("pojoDto")
    @ResponseStatus(HttpStatus.CREATED)
    public String postMessage(@RequestBody OrderDto order) {
        return STR."Request accepted, the pojoDto is \{order.toString()}";
    }

    @PostMapping("recordDto")
    @ResponseStatus(HttpStatus.CREATED)
    public String postMessage(@RequestBody OrderRecord order) {
        return STR."Request accepted, the recordDto is \{order.toString()}";
    }

    @GetMapping("/pathVariable/{value}")
    @ResponseStatus(HttpStatus.OK)
    public String pathVariable(@PathVariable("value") String myValue) {
        return STR."Value = \{myValue}";
    }

    @GetMapping("/requestParam")
    @ResponseStatus(HttpStatus.OK)
    public String requestParam(@RequestParam("value") String myValue) {
        return STR."Value = \{myValue}";
    }

}
