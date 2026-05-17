import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;

class GeneratorTest {

    @Test
    void GeneratePassword_ShouldGeneratePasswordWithAllOptionsSelected() {
        // Arrange
        final String expectedLength = "10";
        final String mockAlphabetChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        when(mock(Scanner.class).next()).thenReturn(expectedLength);
        
        Generator generator = new Generator(true, true, true, true);
        generator.keyboard = mock(Scanner.class);

        // Act
        Password password = generator.GeneratePassword(Integer.parseInt(expectedLength));

        // Assert
        assertEquals(Integer.parseInt(expectedLength), password.getPassword().length());
    }

    @Test
    void GeneratePassword_ShouldGeneratePasswordWithOnlyUppercaseSelected() {
        // Arrange
        final String expectedLength = "5";
        when(mock(Scanner.class).next()).thenReturn(expectedLength);

        Generator generator = new Generator(true, false, false, false);
        generator.keyboard = mock(Scanner.class);

        // Act
        Password password = generator.GeneratePassword(Integer.parseInt(expectedLength));

        // Assert
        assertEquals(5, password.getPassword().length());
    }

    @Test
    void GeneratePassword_ShouldThrowExceptionWhenNoOptionsSelected() {
        // Arrange
        final String expectedLength = "10";
        when(mock(Scanner.class).next()).thenReturn(expectedLength);

        Generator generator = new Generator(false, false, false, false);
        generator.keyboard = mock(Scanner.class);

        // Act & Assert
        assertThrows(Exception.class, () -> {
            generator.requestPassword();
        });
    }

    @Test
    void GeneratePassword_ShouldGenerateShortPasswordWhenMinimumLengthRequested() {
        // Arrange
        final String expectedLength = "1";

        Generator generator = new Generator(true, true, true, true);

        // Act
        Password password = generator.GeneratePassword(Integer.parseInt(expectedLength));

        // Assert
        assertEquals(1, password.getPassword().length());
    }

    @Test
    void GeneratePassword_ShouldGenerateLongPasswordWhenMaximumLengthRequested() {
        // Arrange
        final String expectedLength = "20";

        Generator generator = new Generator(true, true, true, true);

        // Act
        Password password = generator.GeneratePassword(Integer.parseInt(expectedLength));

        // Assert
        assertEquals(20, password.getPassword().length());
    }
}