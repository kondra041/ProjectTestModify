package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Multiply;

class MultiplyTest {

    @Test
    void testGetResultWithNoArguments() {
        Multiply multiply = new Multiply();
        assertEquals(1.0, multiply.getResult());
    }

    @Test
    void testGetResultWithSingleNumber() {
        Multiply multiply = new Multiply();
        assertEquals(5.0, multiply.getResult(5.0));
    }

    @Test
    void testGetResultWithPositiveNumbers() {
        Multiply multiply = new Multiply();
        assertEquals(6.0, multiply.getResult(2.0, 3.0));
    }

    @Test
    void testGetResultWithNegativeNumbers() {
        Multiply multiply = new Multiply();
        assertEquals(-6.0, multiply.getResult(-2.0, 3.0));
        assertEquals(18.0, multiply.getResult(-2.0, -3.0));
    }

    @Test
    void testGetResultWithZero() {
        Multiply multiply = new Multiply();
        assertEquals(0.0, multiply.getResult(2.0, 0.0));
        assertEquals(0.0, multiply.getResult(0.0, 5.0));
    }
}