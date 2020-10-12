package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TennisMatchTest {
    TennisMatch testMatch;
    MatchDetails testDetails;
    MatchStats testStats;

    @Test
    void testConstructor() {
        testDetails = new MatchDetails("James Blake", false, "GRASS", 70, "1/1/2020");
        testStats = new MatchStats("0-6 3-6", 1, 5, 2, 11);
        testMatch = new TennisMatch(testDetails, testStats);

        assertEquals("James Blake", testDetails.getOpponent());
        assertFalse(testDetails.getIsWon());
        assertEquals("GRASS", testDetails.getSurface());
        assertEquals(70, testDetails.getDuration());
        assertEquals("1/1/2020", testDetails.getDate());

        assertEquals("0-6 3-6", testStats.getScore());
        assertEquals(1, testStats.getAces());
        assertEquals(5, testStats.getDoubleFaults());
        assertEquals(2, testStats.getWinners());
        assertEquals(11, testStats.getUnforcedErrors());
    }
}