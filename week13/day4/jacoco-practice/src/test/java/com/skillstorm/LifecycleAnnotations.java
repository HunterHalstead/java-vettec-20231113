package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

public class LifecycleAnnotations {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
        assertTrue(true);
    }

    @Test
    void test2() {
        System.out.println("Test 2");
        assertTrue(true);
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }
}

