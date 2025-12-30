package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test class for Password implementations.
 * 
 * To test different buggy versions, simply uncomment the corresponding
 * getPassword() method and comment out the others.
 * 
 * Available implementations:
 * - Password: Correct implementation
 * - BugDoesNotTrim: Does not trim whitespace
 * - BugToShortPassword: Allows passwords shorter than 12 characters
 * - BugVeryShort: Allows way to short passwords
 * - BugWrongExceptionMessage: Wrong exception message for short passwords
 * - BugMissingPasswordLengthCheck: Does not throw exception for short passwords
 * - BugMissingNumberCheck: Does not throw exception if password lacks a number
 * - BugIsPasswordSameAlwaysTrue: isPasswordSame always returns true
 * - BugWrongHashingAlgorithm: Wrong hashing algorithm
 */

public class PasswordTest {
    
    private IPassword getPassword(String s) throws Exception {
        return (IPassword) new Password(s);
        // return (IPassword) new BugDoesNotTrim(s);
        // return (IPassword) new BugToShortPassword(s);
        // return (IPassword) new BugVeryShort(s);
        // return (IPassword) new BugWrongExceptionMessage(s);
        // return (IPassword) new BugMissingPasswordLengthCheck(s);
        // return (IPassword) new BugMissingNumberCheck(s);
        // return (IPassword) new BugIsPasswordSameAlwaysTrue(s);
        // return (IPassword) new BugWrongHashingAlgorithm(s);
        // return (IPassword) new BugNumberMustBeLast(s); // Testing my own bug version i made

    }

    @Test
    public void constructorShouldTrimWhitespaceForValidPasswords() throws Exception {
        IPassword a = getPassword("Abcdefghijk1");
        IPassword b = getPassword("  Abcdefghijk1  ");
        assertTrue(a.isPasswordSame(b));
    }

    @Test
    public void constructorShouldThrowExceptionForShortPasswords() {
        Exception ex = assertThrows(Exception.class, () -> getPassword("Abcdefghij1"));
        assertEquals("To short password", ex.getMessage());
    }

    @Test
    public void constructorShouldThrowExceptionForPasswordsWithoutNumber() {
        Exception ex = assertThrows(Exception.class, () -> getPassword("Abcdefghijkl"));
        assertEquals("Does not contain a number", ex.getMessage());
    }

    @Test
    public void isPasswordSameShouldReturnFalseForDifferentPasswords() throws Exception {
        IPassword a = getPassword("Abcdefghijk1");
        IPassword b = getPassword("Abcdefghijk2");
        assertFalse(a.isPasswordSame(b));
    }

    @Test
    public void getPasswordHashShouldReturnExpectedHashForKnownPassword() throws Exception {
        IPassword p = getPassword("Abcdefghijk1");
        assertEquals(-1583411662, p.getPasswordHash());
    }

}