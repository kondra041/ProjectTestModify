package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    public void testGetResult() {
        Divide divide = new Divide();
        assertEquals(2.0, divide.getResult(8.0, 4.0));
        assertEquals(0.5, divide.getResult(1.0, 2.0));
        assertEquals(3.0, divide.getResult(9.0, 3.0));
    }

    @Test
    public void testGetResultWithZero() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}