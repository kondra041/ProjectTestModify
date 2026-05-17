package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    public void testGetResultWithMultipleNumbers() {
        Operate divide = new Divide();
        Double result = divide.getResult(8.0, 2.0, 2.0);
        assertEquals(2.0, result);
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Operate divide = new Divide();
        Double result = divide.getResult(4.0);
        assertEquals(4.0, result);
    }

    @Test
    public void testGetResultWithZeroDivider() {
        Operate divide = new Divide();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            divide.getResult(8.0, 0.0);
        });
        assertEquals("/ by zero", exception.getMessage());
    }
}