package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Multiply;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {

    @Test
    public void testMultiply() {
        Multiply multiply = new Multiply();
        assertEquals(24.0, multiply.getResult(2.0, 3.0, 4.0));
        assertEquals(0.0, multiply.getResult(0.0, 1.0, 2.0));
        assertEquals(1.0, multiply.getResult(1.0, 1.0, 1.0));
        assertEquals(-6.0, multiply.getResult(-2.0, 3.0));
    }
}