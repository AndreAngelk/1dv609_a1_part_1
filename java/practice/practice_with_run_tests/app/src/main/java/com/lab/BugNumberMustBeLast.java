package com.lab;

// Down below is a new custom made buggy version of Password
// This Buggy version successfully passes all the tests

public class BugNumberMustBeLast implements IPassword {
    protected int passwordHash;

    public BugNumberMustBeLast(String pw) throws Exception {
        String trimmedPW = pw.trim();

        if (trimmedPW.length() < 12) {
            throw new Exception("To short password");
        }

        // BUG: Only accepts a number if it is the LAST character.
        // Correct Password accepts a number anywhere in the password.
        if (!trimmedPW.matches(".*\\d")) {
            throw new Exception("Does not contain a number");
        }

        this.passwordHash = simpleHash(trimmedPW);
    }

    private int simpleHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }
        return hash;
    }

    @Override
    public int getPasswordHash() {
        return this.passwordHash;
    }

    @Override
    public boolean isPasswordSame(IPassword other) {
        return this.passwordHash == other.getPasswordHash();
    }
}
