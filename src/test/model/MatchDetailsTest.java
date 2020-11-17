package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MatchDetailsTest {
    private MatchDetails testDetails1;
    private MatchDetails testDetails2;
    private MatchDetails testDetails3;

    @BeforeEach
    void runBefore() {
        testDetails1 = new MatchDetails("Yang Lin", false, "HARD", 45, "1/1/2020");
        testDetails2 = new MatchDetails("Yang Lin", false, "HARD", 45, "1/1/2020");
        testDetails3 = new MatchDetails("Roger Federer", false, "HARD", 45, "1/1/2020");
    }


    @Test
    void testConstructor() {
        assertEquals("Yang Lin", testDetails1.getOpponent());
        assertFalse(testDetails1.getIsWon());
        assertEquals("HARD", testDetails1.getSurface());
        assertEquals(45, testDetails1.getDuration());
        assertEquals("1/1/2020", testDetails1.getDate());
    }

    @Test
    void testEqualsIsEqual() {
        boolean isEqual = testDetails1.equals(testDetails2);

        assertTrue(isEqual);
    }

    @Test
    void testEqualsIsNotEqual() {
        boolean isEqual = testDetails1.equals(testDetails3);

        assertFalse(isEqual);
    }

    @Test
    void testHashCodesAreEqual() {
        int detailsCode1 = testDetails1.hashCode();
        int detailsCode2 = testDetails2.hashCode();

        assertEquals(detailsCode1, detailsCode2);
    }

    @Test
    void testHashCodesAreNotEqual() {
        int detailsCode1 = testDetails1.hashCode();
        int detailsCode3 = testDetails3.hashCode();

        assertNotEquals(detailsCode1, detailsCode3);
    }
}
