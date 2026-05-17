package generated;

import projectTestModify.emailgenerator.Email;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailTest {

    @Test
    public void testRandomPass() {
        Email email = new Email("John", "Doe");
        String password = email.randomPass(8);
        assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches("[A-Za-z0-9!@#$%]+"));
    }
}