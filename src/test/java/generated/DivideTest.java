package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Divide;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideTest {

    @Test
    public void testDivideTwoNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideMultipleNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(100.0, 2.0, 5.0);
        assertEquals(10.0, result);
    }

    @Test
    public void testDivideByZero() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> {
            divide.getResult(10.0, 0.0);
        });
    }

    @Test
    public void testDivideSingleNumber() {
        Divide divide = new Divide();
        Double result = divide.getResult(5.0);
        assertEquals(5.0, result);
    }
}