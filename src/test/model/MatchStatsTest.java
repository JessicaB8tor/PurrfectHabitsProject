package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchStatsTest {
    MatchStats testStats;

    @Test
    void testConstructor() {
        testStats = new MatchStats("7-5 6-1", 10, 1, 4, 7);

        assertEquals("7-5 6-1", testStats.getScore());
        assertEquals(10, testStats.getAces());
        assertEquals(1, testStats.getDoubleFaults());
        assertEquals(4, testStats.getWinners());
        assertEquals(7, testStats.getUnforcedErrors());
    }
}
