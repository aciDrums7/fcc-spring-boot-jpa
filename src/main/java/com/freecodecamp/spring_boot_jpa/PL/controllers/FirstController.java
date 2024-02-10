package com.freecodecamp.spring_boot_jpa.PL.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    // ^ RequestMappingHandlerMapping is the class that maps these URI to the
    // ^ corrispondent handler method at the boostrapping of Spring App
    @GetMapping("/helloWorld")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello from my first controller";
    }

}
