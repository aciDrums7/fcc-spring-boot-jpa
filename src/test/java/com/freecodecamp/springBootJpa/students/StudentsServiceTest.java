package com.freecodecamp.springBootJpa.students;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class StudentsServiceTest {

    @Mock
    private StudentsService service;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Inside afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Inside beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Inside afterEach");
    }

    @Test
    void should_find_all_students() {
        System.out.println("Inside testFindAll");
        assertTrue(true);
    }
}
