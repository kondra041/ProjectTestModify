package generated;

import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.passwordGenerator.Password;

import org.junit.jupiter.api.Test;

public class PasswordTest {
    @Test
    public void testCharType() {
        Password password = new Password("Test@123");

        assertEquals(1, password.CharType('T')); // Uppercase Letter
        assertEquals(4, password.CharType('@')); // Symbol
        assertEquals(3, password.CharType('1')); // Digit
    }

    @Test
    public void testPasswordStrength() {
        Password weakPassword = new Password("weak");
        Password mediumPassword = new Password("Medium@123");
        Password strongPassword = new Password("StrongP@ssw0rdWithMoreThan16Chars");

        assertEquals(2, weakPassword.PasswordStrength()); // Only lowercase letters and length < 8
        assertEquals(5, mediumPassword.PasswordStrength()); // Uppercase, lowercase, digits, symbols, and length >= 8 but < 16
        assertEquals(7, strongPassword.PasswordStrength()); // Uppercase, lowercase, digits, symbols, and length >= 16
    }

    @Test
    public void testCalculateScore() {
        Password weakPassword = new Password("weak");
        Password mediumPassword = new Password("Medium@123");
        Password strongPassword = new Password("StrongP@ssw0rdWithMoreThan16Chars");

        assertEquals("This is a weak password :( definitely find a new one", weakPassword.calculateScore());
        assertEquals("This is a good password :) but you can still do better", mediumPassword.calculateScore());
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", strongPassword.calculateScore());
    }
}