package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

public class GeneratorTest {

    @Mock
    private Scanner scanner;

    private Generator generator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        generator = new Generator(scanner);
    }

    @Test
    public void testMainLoopWithInvalidOption() {
        when(scanner.next()).thenReturn("5");

        generator.mainLoop();

        verify(scanner, times(1)).next();
        // Additional assertions can be added here to verify the output or state after invalid option
    }

    @Test
    public void testGeneratePasswordLength() {
        int length = 10;
        String alphabetMock = "abcdef";
        Alphabet alphabet = new Alphabet(true, true, false, false);
        generator = new Generator(alphabet);

        Password password = generator.GeneratePassword(length);

        assertEquals(length, password.getValue().length());
    }

    @Test
    public void testGeneratePasswordCharacters() {
        int length = 5;
        String alphabetMock = "abcdef";
        Alphabet alphabet = new Alphabet(true, true, false, false);
        generator = new Generator(alphabet);

        Password password = generator.GeneratePassword(length);

        for (char c : password.getValue().toCharArray()) {
            assertTrue(alphabet.getAlphabet().indexOf(c) != -1);
        }
    }

    @Test
    public void testRequestPasswordWithNoOptions() {
        when(scanner.nextLine()).thenReturn("no", "no", "no", "no");

        generator.requestPassword();

        // Additional assertions can be added here to verify the output or state after no options are selected
    }

    @Test
    public void testCheckPasswordStrength() {
        when(scanner.nextLine()).thenReturn("a1b2c3d4");

        generator.checkPassword();

        // Additional assertions can be added here to verify the output or state after checking password strength
    }
}