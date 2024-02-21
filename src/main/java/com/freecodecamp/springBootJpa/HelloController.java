package com.freecodecamp.springBootJpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // ^ RequestMappingHandlerMapping is the class that maps these URI to the
    // ^ corrispondent handler method at the boostrapping of Spring App
    @GetMapping("/helloWorld")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello from my first controller";
    }
}
