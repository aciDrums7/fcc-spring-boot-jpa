package com.freecodecamp.spring_boot_jpa;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJpaApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("Spring Boot Context loads correctly");
        assertTrue(true);
    }
}
