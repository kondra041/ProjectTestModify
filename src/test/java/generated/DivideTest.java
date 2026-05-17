package generated;

import projectTestModify.CalculatorOOPS.Divide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {

    @Test
    public void testGetResult() {
        Divide divide = new Divide();
        assertEquals(2.0, divide.getResult(10.0, 5.0));
        assertEquals(1.0, divide.getResult(10.0, 2.0, 5.0));
        assertNull(divide.getResult());
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}