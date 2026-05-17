package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {

    @Test
    public void testCharType_Uppercase() {
        Password password = new Password("A");
        assertEquals(1, password.CharType('A'));
    }

    @Test
    public void testCharType_Lowercase() {
        Password password = new Password("a");
        assertEquals(2, password.CharType('a'));
    }

    @Test
    public void testCharType_Digit() {
        Password password = new Password("0");
        assertEquals(3, password.CharType('0'));
    }

    @Test
    public void testCharType_Symbol() {
        Password password = new Password("@");
        assertEquals(4, password.CharType('@'));
    }

    @Test
    public void testPasswordStrength_AllCriteriaMet() {
        Password password = new Password("Aa123456@");
        assertEquals(6, password.PasswordStrength());
    }

    @Test
    public void testPasswordStrength_MissingUppercase() {
        Password password = new Password("a123456@");
        assertEquals(5, password.PasswordStrength());
    }

    @Test
    public void testPasswordStrength_MissingLowercase() {
        Password password = new Password("A123456@");
        assertEquals(5, password.PasswordStrength());
    }

    @Test
    public void testPasswordStrength_MissingDigit() {
        Password password = new Password("Aa@");
        assertEquals(5, password.PasswordStrength());
    }

    @Test
    public void testPasswordStrength_MissingSymbol() {
        Password password = new Password("Aa123456");
        assertEquals(5, password.PasswordStrength());
    }

    @Test
    public void testCalculateScore_VeryGoodPassword() {
        Password password = new Password("Aa123456@");
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", password.calculateScore());
    }

    @Test
    public void testCalculateScore_GoodPassword() {
        Password password = new Password("Aa123456");
        assertEquals("This is a good password :) but you can still do better", password.calculateScore());
    }

    @Test
    public void testCalculateScore_MediumPassword() {
        Password password = new Password("Aa12@");
        assertEquals("This is a medium password :/ try making it better", password.calculateScore());
    }

    @Test
    public void testCalculateScore_WeakPassword() {
        Password password = new Password("abc");
        assertEquals("This is a weak password :( definitely find a new one", password.calculateScore());
    }
}