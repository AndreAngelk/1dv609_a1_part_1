package com.lab;

// In each of the 4 tests down below you can test the SSN buggy versions one at a time by commenting/uncommenting

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SwedishSocialSecurityNumberTest {

    private SSNHelper helper;

    @BeforeEach
    public void setUp() {
        helper = mock(SSNHelper.class);
    }

    @Test
    public void constructorShouldTrimWhitespaceForValidInput() throws Exception {
        String input = " 900101-0017 ";
        String trimmed = "900101-0017";

        when(helper.isCorrectLength(trimmed)).thenReturn(true);
        when(helper.isCorrectFormat(trimmed)).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect(trimmed)).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber(input, helper);
        // BuggySwedishSocialSecurityNumberNoTrim ssn = new BuggySwedishSocialSecurityNumberNoTrim(input, helper);

        assertEquals("900101-0017", ssn.getSSN());
    }

    @Test
    public void constructorShouldThrowExceptionForWrongLength() {
        String input = "900101-00170"; // 12 chars

        when(helper.isCorrectLength(input)).thenReturn(false);

        Exception ex = assertThrows(Exception.class,
                () -> new SwedishSocialSecurityNumber(input, helper));
        // Exception ex = assertThrows(Exception.class,
        //        () -> new BuggySwedishSocialSecurityNumberNoLenCheck(input, helper));

        assertEquals("To short, must be 11 characters", ex.getMessage());
    }

    @Test
    public void constructorShouldThrowExceptionWhenLuhnFails() {
        String input = "900101-0017";

        when(helper.isCorrectLength(input)).thenReturn(true);
        when(helper.isCorrectFormat(input)).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect(input)).thenReturn(false);

        Exception ex = assertThrows(Exception.class,
                () -> new SwedishSocialSecurityNumber(input, helper));
        // Exception ex = assertThrows(Exception.class,
        //        () -> new BuggySwedishSocialSecurityNumberNoLuhn(input, helper));

        assertEquals("Invalid SSN according to Luhn's algorithm", ex.getMessage());
    }

    @Test
    public void getYearShouldReturnFirstTwoDigitsForValidSSN() throws Exception {
        String input = "900101-0017";

        when(helper.isCorrectLength(input)).thenReturn(true);
        when(helper.isCorrectFormat(input)).thenReturn(true);
        when(helper.isValidMonth("01")).thenReturn(true);
        when(helper.isValidDay("01")).thenReturn(true);
        when(helper.luhnIsCorrect(input)).thenReturn(true);

        SwedishSocialSecurityNumber ssn = new SwedishSocialSecurityNumber(input, helper);
        // BuggySwedishSocialSecurityNumberWrongYear ssn = new BuggySwedishSocialSecurityNumberWrongYear(input, helper);

        assertEquals("90", ssn.getYear());
    }
}
