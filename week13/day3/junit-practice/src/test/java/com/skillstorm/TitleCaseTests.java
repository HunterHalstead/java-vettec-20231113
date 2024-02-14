package com.skillstorm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Team Dragon
 */
public class TitleCaseTests {
	GroupWork work = new GroupWork();

	@Test
	void testMinorWords() {
		assertEquals("The Lord of the Rings", work.titleCase("the lord of the rings"));
	}

	@Test
	void testTitleComma() {
		assertEquals("O Brother, Where Art Thou?", work.titleCase("o brother, where art thou?"));
	}

	@Test
	void testHyphenatedMajorWords() {
		assertEquals("Spider-Man 2", work.titleCase("spider-man 2"));
	}

	@Test
    void testAllCaps() {
        assertEquals("Vertigo", work.titleCase("VERTIGO"));
	}

	@Test
	void testFirstWordConjunction() {
		assertEquals("For Whom the Bell Tolls", work.titleCase("for whom the bell tolls"));
	}

	@Test
	void testColon() {
		assertEquals("The Lord of the Rings: The Two Towers", work.titleCase("the lord of the Rings: the two Towers"));
	}
}
