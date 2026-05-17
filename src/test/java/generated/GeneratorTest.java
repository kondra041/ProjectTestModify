package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Password;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GeneratorTest {

    private Scanner scanner;
    private Generator generator;

    @BeforeEach
    public void setUp() {
        scanner = mock(Scanner.class);
        generator = new Generator(scanner);
    }

    @Test
    public void testCheckPasswordValidInput() {
        when(scanner.nextLine()).thenReturn("password123");

        Password mockPassword = mock(Password.class);
        when(mockPassword.calculateScore()).thenReturn(8);

        System.out.println("\nEnter your password:");
        generator.checkPassword();
    }

    @Test
    public void testCheckPasswordInvalidInput() {
        when(scanner.nextLine()).thenReturn("weakpass");

        Password mockPassword = mock(Password.class);
        when(mockPassword.calculateScore()).thenReturn(4);

        System.out.println("\nEnter your password:");
        generator.checkPassword();
    }
}