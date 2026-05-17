package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GeneratorTest {

    @Mock
    private Scanner keyboard;

    private Generator generator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        generator = new Generator(keyboard);
    }

    @Test
    public void testGeneratePassword() {
        when(keyboard.nextInt()).thenReturn(5); // Mocking user input for password length

        // Test with all character types included
        when(keyboard.nextLine()).thenReturn("yes").thenReturn("yes").thenReturn("yes").thenReturn("yes");
        Password generatedPassword = generator.GeneratePassword(5);
        assertEquals(5, generatedPassword.toString().length());
        assertTrue(generatedPassword.toString().matches("[a-zA-Z0-9!@#$%^&*()_+]+"));

        // Test with some character types included
        when(keyboard.nextLine()).thenReturn("yes").thenReturn("no").thenReturn("yes").thenReturn("no");
        generatedPassword = generator.GeneratePassword(5);
        assertEquals(5, generatedPassword.toString().length());
        assertTrue(generatedPassword.toString().matches("[a-zA-Z0-9]+"));
    }
}