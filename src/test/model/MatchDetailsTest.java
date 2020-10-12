package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MatchDetailsTest {
    private MatchDetails testDetails;

    @Test
    void testConstructor() {
        testDetails = new MatchDetails("Yang Lin", false, "HARD", 45, "1/1/2020");

        assertEquals("Yang Lin", testDetails.getOpponent());
        assertFalse(testDetails.getIsWon());
        assertEquals("HARD", testDetails.getSurface());
        assertEquals(45, testDetails.getDuration());
        assertEquals("1/1/2020", testDetails.getDate());
    }
}
