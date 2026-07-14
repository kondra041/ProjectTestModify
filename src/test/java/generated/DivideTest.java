import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Dependencies.Dependencies;

public class TestDivide {

    @Test
    void testDivideTwoNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(8.0, 2.0);
        assertEquals(4.0, result);
    }

    @Test
    void testDivideMultipleNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(16.0, 2.0, 2.0);
        assertEquals(4.0, result);
    }

    @Test
    void testSingleNumberDivision() {
        Divide divide = new Divide();
        Double result = divide.getResult(5.0);
        assertEquals(5.0, result);
    }

    @Test
    void testDivideByZero() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}