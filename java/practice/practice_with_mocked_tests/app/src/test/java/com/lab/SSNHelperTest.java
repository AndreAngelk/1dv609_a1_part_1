package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SSNHelperTest {

    private interface HelperApi {
        boolean isCorrectLength(String s);
        boolean isCorrectFormat(String s);
        boolean isValidMonth(String s);
        boolean isValidDay(String s);
        boolean luhnIsCorrect(String s);
    }

    private HelperApi getHelper() {

         SSNHelper h = new SSNHelper();
         return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
         };

        // Switch to ONE buggy helper at a time:
        // BuggySSNHelperWrongLength bug = new BuggySSNHelperWrongLength();
        // return api(bug);
        //
        // BuggySSNHelperAllowMonth0 bug = new BuggySSNHelperAllowMonth0();
        // return api(bug);
        //
        // BuggySSNHelperAllowDayUpTo30 bug = new BuggySSNHelperAllowDayUpTo30();
        // return api(bug);
        //
        // BuggySSNHelperIncorrectFormat bug = new BuggySSNHelperIncorrectFormat();
        // return api(bug);
        //
        // BuggySSNHelperIncorrectFormatFalse bug = new BuggySSNHelperIncorrectFormatFalse();
        // return api(bug);
        //
        // BuggySSNHelperMessyLuhn bug = new BuggySSNHelperMessyLuhn();
        // return api(bug);
        //
        // BuggySSNHelperAllowDay0 bug = new BuggySSNHelperAllowDay0();
        // return api(bug);
    }

    private HelperApi api(BuggySSNHelperWrongLength h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperAllowMonth0 h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperAllowDayUpTo30 h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperIncorrectFormat h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperIncorrectFormatFalse h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperMessyLuhn h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }

    private HelperApi api(BuggySSNHelperAllowDay0 h) {
        return new HelperApi() {
            public boolean isCorrectLength(String s) { return h.isCorrectLength(s); }
            public boolean isCorrectFormat(String s) { return h.isCorrectFormat(s); }
            public boolean isValidMonth(String s) { return h.isValidMonth(s); }
            public boolean isValidDay(String s) { return h.isValidDay(s); }
            public boolean luhnIsCorrect(String s) { return h.luhnIsCorrect(s); }
        };
    }


    @Test
    public void isCorrectLengthShouldReturnFalseFor12Characters() {
        HelperApi h = getHelper();
        assertFalse(h.isCorrectLength("900101-00170"));
    }

    @Test
    public void isValidMonthShouldReturnFalseFor00() {
        HelperApi h = getHelper();
        assertFalse(h.isValidMonth("00"));
    }

    @Test
    public void isValidDayShouldReturnTrueFor31() {
        HelperApi h = getHelper();
        assertTrue(h.isValidDay("31"));
    }

    @Test
    public void isCorrectFormatShouldReturnFalseWhenHyphenMissing() {
        HelperApi h = getHelper();
        assertFalse(h.isCorrectFormat("9001010017"));
    }

    @Test
    public void isCorrectFormatShouldReturnTrueForValidPattern() {
        HelperApi h = getHelper();
        assertTrue(h.isCorrectFormat("900101-0017"));
    }

    @Test
    public void luhnIsCorrectShouldReturnTrueForKnownValidSSN() {
        HelperApi h = getHelper();
        assertTrue(h.luhnIsCorrect("900101-0017"));
    }

    // Additional test for the custom bug
    @Test
    public void isValidDayShouldReturnFalseFor00() {
        HelperApi h = getHelper();
        assertFalse(h.isValidDay("00"));
    }
}
