import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;

@ExtendWith(MockitoExtension.class)
public class GeneratorCheckPasswordTest {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private Generator generator;

    @Test
    public void testStrongPassword() {
        String input = "Qwerty123!";
        when(scanner.nextLine()).thenReturn(input);
        
        generator.checkPassword();
        
        verify(scanner).nextLine();
        // Assuming calculateScore returns 5 for a strong password
        assertEquals(5, Password.calculateScore(input));
    }

    @Test
    public void testWeakPassword() {
        String input = "password";
        when(scanner.nextLine()).thenReturn(input);
        
        generator.checkPassword();
        
        verify(scanner).nextLine();
        // Assuming calculateScore returns 1 for a weak password
        assertEquals(1, Password.calculateScore(input));
    }

    @Test
    public void testEmptyPassword() {
        String input = "";
        when(scanner.nextLine()).thenReturn(input);
        
        generator.checkPassword();
        
        verify(scanner).nextLine();
        // Assuming calculateScore returns 0 for empty password
        assertEquals(0, Password.calculateScore(input));
    }
}