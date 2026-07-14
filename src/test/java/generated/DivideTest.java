package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Divide;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {

    @Test
    public void testDivide() {
        Divide divide = new Divide();
        assertEquals(4.0, divide.getResult(16.0, 2.0, 2.0));
        assertEquals(5.0, divide.getResult(10.0, 2.0));
        assertEquals(1.0, divide.getResult(5.0, 5.0));
    }

    @Test
    public void testDivideSingleNumber() {
        Divide divide = new Divide();
        assertEquals(10.0, divide.getResult(10.0));
    }
}