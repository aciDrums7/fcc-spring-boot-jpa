package com.freecodecamp.spring_boot_jpa;

// @Component
public class MyFirstClass {

    private String name;

    /**
     * @param name
     */
    public MyFirstClass(String myString) {
        this.name = myString;
    }

    public String helloWorld() {
        return "Hello World!";
    }

    public String sayHello() {
        return STR."Hello from the MyFirstClass ==> name = \{name}";
    }
}
