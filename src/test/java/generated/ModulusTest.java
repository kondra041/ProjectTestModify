package generated;

import projectTestModify.CalculatorOOPS.Modulus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ModulusTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        // Arrange
        Modulus modulus = new Modulus();
        Double[] numbers = {10.5, 3.0, 2.0};
        
        // Act
        Double result = modulus.getResult(numbers);
        
        // Assert
        assertEquals(1.5, result);
    }
}