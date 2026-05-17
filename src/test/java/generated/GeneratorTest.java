package generated;

import projectTestModify.passwordGenerator.Alphabet;
import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GeneratorTest {
    @org.junit.jupiter.api.Test
    public void testGeneratePassword() {
        Alphabet alphabet = new Alphabet(true, true, true, true);
        Generator generator = new Generator(alphabet);
        Password password = generator.generatePassword(10);
        assertNotNull(password);
        assertEquals(10, password.getPassword().length());
    }

    @org.junit.jupiter.api.Test
    public void testMainLoop() {
        String input = "4\n"; // quit option
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Alphabet alphabet = new Alphabet(true, true, true, true);
        Scanner scanner = new Scanner(System.in);
        Generator generator = new Generator(scanner) {
            @Override
            public void printQuitMessage() {
                // do nothing to avoid printing messages during tests
            }
        };

        generator.mainLoop();

        scanner.close();
    }

    // Add more test methods for other methods in Generator class if needed
}