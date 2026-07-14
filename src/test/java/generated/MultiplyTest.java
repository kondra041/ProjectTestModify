package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Multiply;

public class MultiplyTest {

    @Test
    public void testGetResult() {
        Multiply multiply = new Multiply();
        
        assertEquals(6.0, multiply.getResult(1.0, 2.0, 3.0));
        assertEquals(0.0, multiply.getResult(0.0, 1.0, 2.0));
        assertEquals(9.0, multiply.getResult(3.0, 3.0));
        assertEquals(1.0, multiply.getResult());
    }
}