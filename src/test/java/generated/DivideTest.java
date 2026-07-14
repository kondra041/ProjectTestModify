package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    public void testGetResultWithValidNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(8.0, 2.0, 4.0);
        assertEquals(1.0, result);
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Divide divide = new Divide();
        Double result = divide.getResult(10.0);
        assertEquals(10.0, result);
    }

    @Test
    public void testGetResultWithZeroDivisor() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> divide.getResult(8.0, 0.0));
    }
}