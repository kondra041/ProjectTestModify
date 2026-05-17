package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {

    @Test
    public void testPasswordStrength() {
        Password password = new Password("Aa1!2345");
        assertEquals(6, password.PasswordStrength());
    }

    @Test
    public void testCalculateScore_VeryGoodPassword() {
        Password password = new Password("Aa1!234567890123");
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", password.calculateScore());
    }

    @Test
    public void testCalculateScore_GoodPassword() {
        Password password = new Password("Aa1!23456789");
        assertEquals("This is a good password :) but you can still do better", password.calculateScore());
    }

    @Test
    public void testCalculateScore_MediumPassword() {
        Password password = new Password("Aa1!234");
        assertEquals("This is a medium password :/ try making it better", password.calculateScore());
    }

    @Test
    public void testCalculateScore_WeakPassword() {
        Password password = new Password("Aa!");
        assertEquals("This is a weak password :( definitely find a new one", password.calculateScore());
    }
}