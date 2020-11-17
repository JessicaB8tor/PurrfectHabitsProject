package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MatchStatsTest {
    MatchStats testStats1;
    MatchStats testStats2;
    MatchStats testStats3;

    @BeforeEach
    void runBefore() {
        testStats1 = new MatchStats("7-5 6-1", 10, 1, 4, 7);
        testStats2 = new MatchStats("7-5 6-1", 10, 1, 4, 7);
        testStats3 = new MatchStats("7-5 6-1", 9, 1, 4, 7);
    }

    @Test
    void testConstructor() {
        assertEquals("7-5 6-1", testStats1.getScore());
        assertEquals(10, testStats1.getAces());
        assertEquals(1, testStats1.getDoubleFaults());
        assertEquals(4, testStats1.getWinners());
        assertEquals(7, testStats1.getUnforcedErrors());
    }

    @Test
    void testEqualsIsEqual() {
        boolean isEqual = testStats1.equals(testStats2);

        assertTrue(isEqual);
    }

    @Test
    void testEqualsIsNotEqual() {
        boolean isEqual = testStats1.equals(testStats3);

        assertFalse(isEqual);
    }

    @Test
    void testHashCodesAreEqual() {
        int statsCode1 = testStats1.hashCode();
        int statsCode2 = testStats2.hashCode();

        assertEquals(statsCode1, statsCode2);
    }

    @Test
    void testHashCodesAreNotEqual() {
        int statsCode1 = testStats1.hashCode();
        int statsCode3 = testStats3.hashCode();

        assertNotEquals(statsCode1, statsCode3);
    }
}
