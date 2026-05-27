package generated;

import projectTestModify.CalculatorOOPS.Multiply;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyTest {

    @Test
    public void testMultiply() {
        Multiply multiply = new Multiply();

        assertEquals(24.0, multiply.getResult(2.0, 3.0, 4.0));
    }
}