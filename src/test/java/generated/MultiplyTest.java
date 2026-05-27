package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.CalculatorOOPS.Multiply;

class MultiplyTest {
    @Test
    void testGetResult() {
        // Create an instance of the Multiply class
        Multiply multiply = new Multiply();

        // Test the getResult method with a single number argument
        assertEquals(10.0, multiply.getResult(10.0), 0.0);

        // Test the getResult method with multiple number arguments
        assertEquals(60.0, multiply.getResult(2.0, 3.0, 5.0), 0.0);
    }
}