package generated;

import projectTestModify.CalculatorOOPS.Multiply;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiplyTest {
    @Test
    public void testGetResult() {
        Multiply multiply = new Multiply();
        Double result = multiply.getResult(2.0, 3.0, 4.0);
        assertEquals(24.0, result, 0.001); // delta used for precision in floating point comparisons
    }
}