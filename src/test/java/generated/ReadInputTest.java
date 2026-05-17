package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.CalculatorOOPS.ReadInput;

@ExtendWith(MockitoExtension.class)
public class ReadInputTest {

    @InjectMocks
    private ReadInput readInput;

    @Mock
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        // Mock the System.in to use our mocked scanner
        when(System.in).thenReturn(scanner);
    }

    @Test
    void readShouldReturnInputLine() {
        String mockInput = "123";
        when(scanner.nextLine()).thenReturn(mockInput);

        String result = ReadInput.read();

        assertEquals(mockInput, result);
        verify(scanner).nextLine();
    }

    @Test
    void readShouldCloseScanner() {
        // Verify that close is called after reading
        doNothing().when(scanner).close();

        ReadInput.read();

        verify(scanner).close();
    }
}