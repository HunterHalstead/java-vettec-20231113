package com.skillstorm;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class OrderedTests {

    @Test
    @Order(1)
    void nullValues() {
        System.out.println("null test");
    	assertNull(null);
    }

    @Test
    @Order(2)
    void emptyValues() {
    	System.out.println("empty value test");
        assertTrue("".isEmpty());
    }

    @Test
    @Order(1)
    void validValues() {
    	System.out.println("valid value test");
        assertEquals(1, 1);
    }

}
