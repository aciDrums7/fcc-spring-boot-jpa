package com.freecodecamp.spring_boot_jpa;

import static java.lang.StringTemplate.STR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    // ? 2 - Field Injection
    // @Autowired
    // @Qualifier("mySecondBean") //* qualifier search by @Bean name or @Qualifier
    private MyFirstClass myFirstClass;

    // ? 1 - Constructor Injection
    // ! RECOMMENDED WAY
    // ^ @Autowired is optional if only one constructor
    // public MyFirstService(/* @Qualifier("bean2") */ MyFirstClass myFirstClass) {
    // this.myFirstClass = myFirstClass;
    // }

    // ? 3 - Method Injection
    @Autowired
    public void injectDependencies(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory() {
        return STR."the dependency is saying: \{myFirstClass.sayHello()}";
    }

    // ? 4 - Setter Injection
    @Autowired
    public void setMyFirstClass(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
}
