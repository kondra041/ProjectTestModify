package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivideTest {

    private Divide divide;

    @BeforeEach
    public void setUp() {
        divide = new Divide();
    }

    @Test
    public void testGetResultWithTwoNumbers() {
        assertEquals(2.0, divide.getResult(10.0, 5.0));
    }

    @Test
    public void testGetResultWithThreeNumbers() {
        assertEquals(2.0 / 3.0, divide.getResult(6.0, 3.0, 2.0), 0.0001);
    }

    @Test
    public void testGetResultWithZeroDivisor() {
        assertThrows(ArithmeticException.class, () -> divide.getResult(10.0, 0.0));
    }

    @Test
    public void testGetResultWithSingleNumber() {
        assertEquals(10.0, divide.getResult(10.0));
    }
}