import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;

class GeneratePasswordTests {

    @Test
    void testZeroLength() {
        Generator generator = new Generator(true, true, true, true);
        assertThrows(IllegalArgumentException.class, () -> generator.GeneratePassword(0));
    }

    @Test
    void testMinimumValidLength() {
        Generator generator = new Generator(true, true, true, true);
        Password password = generator.GeneratePassword(1);
        assertEquals(1, password.getPassword().length());
    }

    @Test
    void testMaximumUsableLength() {
        int maxLength = 20;
        Generator generator = new Generator(true, true, true, true);
        Password password = generator.GeneratePassword(maxLength);
        assertEquals(maxLength, password.getPassword().length());
    }

    @Test
    void testInvalidCharacters() {
        Generator generator = new Generator(false, false, false, false);
        assertThrows(IllegalArgumentException.class, () -> generator.GeneratePassword(8));
    }

    @Test
    void testIncludeAllTypes() {
        // Mocking the random selection to ensure all types are included
        when(Math.random()).thenReturn(0.0, 1.0 / 4.0, 2.0 / 4.0, 3.0 / 4.0);
        
        Generator generator = new Generator(true, true, true, true);
        Password password = generator.GeneratePassword(4);
        
        String pass = password.getPassword();
        assertAll(
            () -> assertTrue(pass.contains("a")), // Lowercase
            () -> assertTrue(pass.contains("A")), // Uppercase
            () -> assertTrue(pass.contains("1")), // Numbers
            () -> assertTrue(pass.contains("!"))  // Symbols
        );
    }
}