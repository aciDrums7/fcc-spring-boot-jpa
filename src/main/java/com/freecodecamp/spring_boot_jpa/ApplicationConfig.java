package com.freecodecamp.spring_boot_jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    // ^ we could either declare this a @Bean or the `HelloWorld` class a @Component
    @Bean("myFirstBean")
    // @Qualifier("bean1")
    MyFirstClass myFirstBean() {
        return new MyFirstClass("First Mr. Bean!");
    }

    @Bean("mySecondBean")
    // @Qualifier("bean2")
    MyFirstClass mySecondBean() {
        return new MyFirstClass("Second Mr. Bean!");
    }

    @Bean("myThirdBean")
    // @Qualifier("bean3")
    @Primary
    MyFirstClass myThirdBean() {
        return new MyFirstClass("Third Mr. Bean!");
    }
}
