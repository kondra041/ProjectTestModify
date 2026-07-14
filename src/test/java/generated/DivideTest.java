package generated;

import projectTestModify.CalculatorOOPS.Divide;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {
    private Divide divide;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        divide = new Divide();
    }

    @org.junit.jupiter.api.Test
    public void testGetResult_SingleNumber() {
        Double result = divide.getResult(10.0);
        assertEquals(10.0, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetResult_MultipleNumbers() {
        Double result = divide.getResult(10.0, 2.0, 5.0);
        assertEquals(1.0, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetResult_DivideByZero() {
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }
}