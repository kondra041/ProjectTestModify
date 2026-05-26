import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Password;

class PasswordTest {

    @Test
    void testEmptyPassword() {
        Password password = new Password("");
        String result = password.calculateScore();
        assertEquals("This is a weak password :( definitely find a new one", result);
    }

    @Test
    void testMinimumRequirements() {
        Password password = new Password("Aa1!");
        String result = password.calculateScore();
        assertEquals("This is a good password :) but you can still do better", result);
    }

    @Test
    void testLengthIncreasesScore() {
        Password strongPassword = new Password("Aa1!LongerPass");
        String result = strongPassword.calculateScore();
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", result);
        
        Password mediumPassword = new Password("Aa1!");
        String mediumResult = mediumPassword.calculateScore();
        assertEquals("This is a good password :) but you can still do better", mediumResult);
    }

    @Test
    void testEdgeCases() {
        Password password7Chars = new Password("Aa1!abc");
        String result7 = password7Chars.calculateScore();
        assertEquals("This is a good password :) but you can still do better", result7);

        Password password16Chars = new Password("Aa1!abcdefghijklmnop");
        String result16 = password16Chars.calculateScore();
        assertEquals("This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines", result16);
    }
}