package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * @author Team Chip
 */
public class GetUserIdTests {

    @Test
    void returnValidIdTest() {
        assertEquals(12345, GroupWork.getUserId("https://www.skillstorm.store.com/user/12345"));
    }

    @Test
    void returnValidIdTest2() {
        assertEquals(12345,
                GroupWork.getUserId("https://www.skillstorm.store.com/user/12345/cart_id/5?checkout=false"));
    }

    // * @throws IllegalArgumentException if the url is null or empty
    @Test
    void assertThrowsIllegalArgumentTest() {
        assertThrows(IllegalArgumentException.class, () -> GroupWork.getUserId(null));
    }

    @Test
    void assertThrowsIllegalArgumentTest2() {
        assertThrows(IllegalArgumentException.class, () -> GroupWork.getUserId(""));
    }

    // * @throws NoSuchElementException if the string does not contain the term
    // "user"
    @Test
    void assertThrowsNoSuchElementTest() {
        assertThrows(NoSuchElementException.class, () -> GroupWork.getUserId("https://www.skillstorm.store.com/"));
    }

    // * @throws NumberFormatException if the /user/ portion of the url is not
    // followed by a valid number
    @Test
    void assertThrowsNumberFormatTest() {
        assertThrows(NumberFormatException.class,
                () -> GroupWork.getUserId("https://www.skillstorm.store.com/user/user5"));
    }
}