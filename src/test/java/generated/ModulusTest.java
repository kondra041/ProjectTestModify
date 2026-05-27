package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.CalculatorOOPS.Modulus;
import java.lang.Double;

public class ModulusTest {
    @Test
    public void testGetResult() {
        // Given
        Double[] numbers = new Double[]{2.0, 3.0, 4.0};
        Modulus modulus = new Modulus();

        // When
        Double result = modulus.getResult(numbers);

        // Then
        assertEquals(1.0, result, 0.01);
    }
}