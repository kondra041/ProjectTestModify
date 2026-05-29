package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    public void testGetResultWithTwoNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(48.0, 6.0, 4.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testGetResultWithZeroDivisorThrowsArithmeticException() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}