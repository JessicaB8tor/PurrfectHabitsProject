package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TennisMatchJournalTest {
    private TennisMatchJournal testJournal;
    private TennisMatch testMatch;
    private TennisMatch testMatch1;
    private TennisMatch testMatch2;
    private MatchDetails testDetails;
    private MatchDetails testDetails1;
    private MatchDetails testDetails2;
    private MatchStats testStats;
    private MatchStats testStats1;
    private MatchStats testStats2;
    private String expected;
    private String actual;

    @BeforeEach
    void runBefore() {
        testDetails = new MatchDetails("Rafa Nadal", true, "clay", 60, "10/11/2020");
        testDetails1 = new MatchDetails("Yang Lin", true, "hard", 30, "1/2/2020");
        testDetails2 = new MatchDetails("Yang Lin", false, "hard", 30, "1/3/2020");
        testStats = new MatchStats("6-1 6-2", 5, 1, 10, 8);
        testStats1 = new MatchStats("7-5 6-4", 2, 0, 13, 9);
        testStats2 = new MatchStats("3-6 1-6", 4, 7, 8, 10);
        testMatch = new TennisMatch(testDetails, testStats);
        testMatch1 = new TennisMatch(testDetails1, testStats1);
        testMatch2 = new TennisMatch(testDetails2, testStats2);
        testJournal = new TennisMatchJournal();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testJournal.journalLength());
    }

    @Test
    void testAddMatchNotAlreadyThere() {
        testJournal.addMatch(testMatch);
        assertTrue(testJournal.containsMatch(testMatch));
    }

    @Test
    void testAddMatchAlreadyThere() {
        testJournal.addMatch(testMatch);
        testJournal.addMatch(testMatch);
        assertEquals(1, testJournal.journalLength());
    }

    @Test
    void testAddMultipleMatches() {
        testJournal.addMatch(testMatch);
        assertEquals(1, testJournal.journalLength());
        testJournal.addMatch(testMatch1);
        assertEquals(2, testJournal.journalLength());
        testJournal.addMatch(testMatch2);
        assertEquals(3, testJournal.journalLength());
    }

    @Test
    void testJournalLength() {
        assertEquals(0, testJournal.journalLength());
        testJournal.addMatch(testMatch);
        assertEquals(1, testJournal.journalLength());
        testJournal.addMatch(testMatch1);
        assertEquals(2, testJournal.journalLength());
    }

    @Test
    void testDeleteExistingMatch() {
        testJournal.addMatch(testMatch);
        assertTrue(testJournal.containsMatch(testMatch));

        testJournal.deleteMatch(testMatch);
        assertFalse(testJournal.containsMatch(testMatch));
    }

    @Test
    void testDeleteNonExistingMatch() {
        testJournal.addMatch(testMatch);
        assertEquals(1, testJournal.journalLength());

        testJournal.deleteMatch(testMatch1);
        assertEquals(1, testJournal.journalLength());
    }

    @Test
    void testDeleteMultipleMatches() {
        testJournal.addMatch(testMatch);
        testJournal.addMatch(testMatch1);
        testJournal.addMatch(testMatch2);
        assertEquals(3, testJournal.journalLength());

        testJournal.deleteMatch(testMatch2);
        assertEquals(2, testJournal.journalLength());
        testJournal.deleteMatch(testMatch);
        assertEquals(1, testJournal.journalLength());
        testJournal.deleteMatch(testMatch1);
        assertEquals(0, testJournal.journalLength());
    }

    @Test
    void testViewJournalOneMatch() {
        testJournal.addMatch(testMatch);

        expected = "\n<DETAILS>\n\tOpponent: Rafa Nadal\n\tOutcome: WIN" +
                "\n\tSurface: CLAY\n\tDuration: 60 minutes\n\tDate: 10/11/2020\n<STATS>" +
                "\n\tScore: 6-1 6-2" + "\n\tAces: 5\n\tDouble Faults: 1\n\tWinners: 10" +
                "\n\tUnforced Errors: 8\n";
        actual = testJournal.viewJournal();

        assertEquals(expected, actual);
    }

    @Test
    void testViewJournalNoMatches() {
        expected = "<YOUR JOURNAL IS EMPTY>";
        actual = testJournal.viewJournal();

        assertEquals(expected, actual);
    }

    @Test
    void testViewJournalTwoMatches() {
        testJournal.addMatch(testMatch);
        testJournal.addMatch(testMatch1);

        expected = "\n<DETAILS>\n\tOpponent: Rafa Nadal\n\tOutcome: WIN" +
                "\n\tSurface: CLAY\n\tDuration: 60 minutes\n\tDate: 10/11/2020\n<STATS>\n\tScore: 6-1 6-2" +
                "\n\tAces: 5\n\tDouble Faults: 1\n\tWinners: 10\n\tUnforced Errors: 8\n" +
                "\n<DETAILS>\n\tOpponent: Yang Lin\n\tOutcome: WIN" +
                "\n\tSurface: HARD\n\tDuration: 30 minutes\n\tDate: 1/2/2020\n<STATS>\n\tScore: 7-5 6-4" +
                "\n\tAces: 2\n\tDouble Faults: 0\n\tWinners: 13\n\tUnforced Errors: 9\n";

        actual = testJournal.viewJournal();

        assertEquals(expected, actual);
    }

    @Test
    void testViewWinLossRatioNoMatches() {
        assertEquals("0 : 0", testJournal.viewWinLossRatio());
    }

    @Test
    void testViewWinLossRatioOneMatch() {
        testJournal.addMatch(testMatch);

        assertEquals("1 : 0", testJournal.viewWinLossRatio());

        testJournal.deleteMatch(testMatch);
        testJournal.addMatch(testMatch2);

        assertEquals("0 : 1", testJournal.viewWinLossRatio());
    }

    @Test
    void testViewWinLossRatioSomeMatches() {
        testJournal.addMatch(testMatch);
        testJournal.addMatch(testMatch1);
        testJournal.addMatch(testMatch2);

        assertEquals("2 : 1", testJournal.viewWinLossRatio());
    }
}


























