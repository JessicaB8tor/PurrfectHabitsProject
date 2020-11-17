package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisMatchTest {
    TennisMatch testMatch1;
    TennisMatch testMatch2;
    TennisMatch testMatch3;
    MatchDetails testDetails1;
    MatchDetails testDetails2;
    MatchDetails testDetails3;
    MatchStats testStats1;
    MatchStats testStats2;
    MatchStats testStats3;

    @BeforeEach
    void runBefore() {
        testDetails1 = new MatchDetails("James Blake", false, "GRASS", 70, "1/1/2020");
        testStats1 = new MatchStats("0-6 3-6", 1, 5, 2, 11);
        testMatch1 = new TennisMatch(testDetails1, testStats1);

        testDetails2 = new MatchDetails("James Blake", false, "GRASS", 70, "1/1/2020");
        testStats2 = new MatchStats("0-6 3-6", 1, 5, 2, 11);
        testMatch2 = new TennisMatch(testDetails2, testStats2);

        testDetails3 = new MatchDetails("Yang Lin", false, "GRASS", 70, "1/1/2020");
        testStats3 = new MatchStats("0-6 3-6", 1, 5, 2, 11);
        testMatch3 = new TennisMatch(testDetails3, testStats3);
    }

    @Test
    void testConstructor() {
        assertEquals("James Blake", testDetails1.getOpponent());
        assertFalse(testDetails1.getIsWon());
        assertEquals("GRASS", testDetails1.getSurface());
        assertEquals(70, testDetails1.getDuration());
        assertEquals("1/1/2020", testDetails1.getDate());

        assertEquals("0-6 3-6", testStats1.getScore());
        assertEquals(1, testStats1.getAces());
        assertEquals(5, testStats1.getDoubleFaults());
        assertEquals(2, testStats1.getWinners());
        assertEquals(11, testStats1.getUnforcedErrors());
    }

    @Test
    void testEqualsIsEqual() {
        boolean equalsTest = testMatch1.equals(testMatch2);

        assertTrue(equalsTest);
    }

    @Test
    void testEqualsIsNotEqual() {
        boolean equalsTest = testMatch1.equals(testMatch3);

        assertFalse(equalsTest);
    }

    @Test
    void testEqualsNotInstanceOf() {
        boolean equalsTest = testMatch1.equals("random string");

        assertFalse(equalsTest);
    }

    @Test
    void testHashCodesAreEqual() {
        int matchCode1 = testMatch1.hashCode();
        int matchCode2 = testMatch2.hashCode();

        assertEquals(matchCode1, matchCode2);
    }

    @Test
    void testHashCodesAreNotEqual() {
        int matchCode1 = testMatch1.hashCode();
        int matchCode3 = testMatch3.hashCode();

        assertNotEquals(matchCode1, matchCode3);
    }
}