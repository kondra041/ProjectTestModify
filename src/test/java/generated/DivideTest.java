package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Operate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTest {

    @Test
    void testSingleNumber() {
        Operate divide = new Divide();
        assertEquals(5.0, divide.getResult(5.0), 1e-9);
    }

    @Test
    void testTwoNumbers() {
        Operate divide = new Divide();
        assertEquals(2.5, divide.getResult(5.0, 2.0), 1e-9);
    }

    @Test
    void testMultipleNumbers() {
        Operate divide = new Divide();
        assertEquals(1.25, divide.getResult(10.0, 2.0, 4.0), 1e-9);
    }

    @Test
    void testDivisionByZero() {
        Operate divide = new Divide();
        assertEquals(Double.POSITIVE_INFINITY, divide.getResult(5.0, 0.0));
    }
}