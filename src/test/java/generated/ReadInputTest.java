package generated;

import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.ReadInput;

public class ReadInputTest {

    @BeforeEach
    public void setUp() {
        // Set up any necessary mock objects or configurations here
    }

    @Test
    public void testRead() {
        // Arrange
        Scanner scanner = new Scanner("4*3/2");
        
        // Act
        String result = ReadInput.read();
        
        // Assert
        assertEquals("4*3/2", result);
        
        // Clean up
        scanner.close();
    }
}