import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Password;

class PasswordTest {

    @Test
    void testStrongPassword() {
        Password password = new Password("Aa1!BCD");
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", 
            password.calculateScore());
    }

    @Test
    void testMediumStrengthPassword() {
        Password password = new Password("Aa12345678");
        assertEquals("This is a good password :) but you can still do better", password.calculateScore());
    }

    @Test
    void testWeakPassword() {
        Password password = new Password("aaaa1111");
        assertEquals("This is a weak password :( definitely find a new one", password.calculateScore());
    }

    @Test
    void testMinimumLengthRequirements() {
        Password password = new Password("Aa1!");
        assertEquals("This is a weak password :( definitely find a new one", password.calculateScore());
    }
}