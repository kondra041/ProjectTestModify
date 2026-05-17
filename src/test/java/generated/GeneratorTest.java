package generated;

import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GeneratorTest {

    private Generator generator;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = mock(Scanner.class);
        generator = new Generator(mockScanner);
    }

    @Test
    public void testGeneratePassword() {
        when(mockScanner.nextInt()).thenReturn(8);
        when(mockScanner.nextLine()).thenReturn("yes").thenReturn("yes").thenReturn("yes").thenReturn("yes");

        Password password = generator.GeneratePassword(8);

        assertEquals(8, password.toString().length());
        assertTrue(password.toString().matches("[a-zA-Z0-9!@#$%^&*()_+{}|:<>?]+"));
    }
}