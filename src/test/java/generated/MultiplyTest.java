package generated;

import projectTestModify.CalculatorOOPS.Multiply;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplyTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        // Test with positive numbers
        assertEquals(24.0, new Multiply().getResult(1.0, 2.0, 3.0, 4.0));

        // Test with zero
        assertEquals(0.0, new Multiply().getResult(5.0, 0.0, 7.0));

        // Test with negative numbers
        assertEquals(-60.0, new Multiply().getResult(-1.0, 2.0, -3.0, 5.0));
    }
}