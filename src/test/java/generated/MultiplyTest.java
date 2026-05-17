package generated;

import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Multiply;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MultiplyTest {
    private Operate multiply;

    @BeforeEach
    void setUp() {
        multiply = new Multiply();
    }

    @Test
    public void testGetResultWithPositiveNumbers() {
        assertEquals(6.0, multiply.getResult(2.0, 3.0));
    }

    @Test
    public void testGetResultWithNegativeNumbers() {
        assertEquals(-6.0, multiply.getResult(2.0, -3.0));
    }

    @Test
    public void testGetResultWithZeroAndPositiveNumber() {
        assertEquals(0.0, multiply.getResult(0.0, 5.0));
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        assertEquals(24.0, multiply.getResult(2.0, 3.0, 4.0));
    }
}