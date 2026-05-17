package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    public void testPasswordStrength() {
        // Test with a password containing all types of characters and length 16
        Password password = new Password("Aa1!Aa1!Aa1!");
        assertEquals(6, password.PasswordStrength());

        // Test with a password missing one type of character
        password = new Password("aaa!aaa");
        assertEquals(5, password.PasswordStrength());

        // Test with a password missing two types of characters
        password = new Password("aaa111");
        assertEquals(4, password.PasswordStrength());

        // Test with a password missing three types of characters
        password = new Password("aaaaaa");
        assertEquals(3, password.PasswordStrength());

        // Test with a password missing all types of characters
        password = new Password("12345678");
        assertEquals(1, password.PasswordStrength());

        // Test with a short password containing all types of characters
        password = new Password("Aa!Aa!");
        assertEquals(3, password.PasswordStrength());
    }
}