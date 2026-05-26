package generated;

import projectTestModify.passwordGenerator.Alphabet;
import projectTestModify.passwordGenerator.Password;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GeneratorTest {
    private final Generator generator = new Generator(true, true, true, true);

    @org.junit.jupiter.api.Test
    public void testGeneratePassword() {
        int length = 8;
        Password password = generator.generatePassword(length);
        assertNotNull(password);
        assertEquals(length, password.getPassword().length());
    }

    @org.junit.jupiter.api.Test
    public void testPrintUsefulInfo() {
        // Redirect System.out to avoid printing to console during testing
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        generator.printUsefulInfo();
        String expectedOutput = "...Expected useful information output..."; // replace with actual expected output
        assertEquals(expectedOutput, outContent.toString());
    }

    @org.junit.jupiter.api.Test
    public void testRequestPassword() {
        Scanner scanner = mock(Scanner.class);
        Generator generator = new Generator(scanner);

        // Mock user inputs for testing
        when(scanner.nextLine()).thenReturn("yes", "yes", "yes", "yes");
        when(scanner.nextInt()).thenReturn(8);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        generator.requestPassword();
        String output = outContent.toString().toLowerCase(); // convert to lowercase for case-insensitive comparison
        assertTrue(output.contains("your generated password"));
    }

    @org.junit.jupiter.api.Test
    public void testCheckPassword() {
        String inputPassword = "StrongP@ssw0rd";
        Password expectedPassword = new Password(inputPassword);
        double expectedScore = expectedPassword.calculateScore();

        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn(inputPassword);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        generator.checkPassword();
        String output = outContent.toString();
        assertTrue(output.contains(String.valueOf(expectedScore)));
    }
}