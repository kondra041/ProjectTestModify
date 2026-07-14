package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Divide;

public class DivideTest {

    @Test
    public void testDivideWithTwoNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideWithThreeNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(64.0, 4.0, 2.0);
        assertEquals(8.0, result);
    }

    @Test
    public void testDivideWithSingleNumber() {
        Divide divide = new Divide();
        Double result = divide.getResult(15.0);
        assertEquals(15.0, result);
    }

    @Test
    public void testDivideByZero() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}