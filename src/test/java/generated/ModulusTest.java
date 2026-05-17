package generated;

import projectTestModify.CalculatorOOPS.Modulus; // Import the project class explicitly
import static org.junit.jupiter.api.Assertions.*;

public class ModulusTest {
    private final Modulus modulus = new Modulus();

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        // Test with positive numbers
        assertEquals(1.0, modulus.getResult(5.0, 2.0));
        assertEquals(0.0, modulus.getResult(4.0, 2.0, 4.0));

        // Test with negative numbers
        assertEquals(-3.0, modulus.getResult(-17.0, -6.0));

        // Test with zero
        assertThrows(ArithmeticException.class, () -> modulus.getResult(5.0, 0.0));
    }
}