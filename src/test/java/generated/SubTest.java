package generated;

import projectTestModify.CalculatorOOPS.Sub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SubTest {

    @Test
    public void testGetResultWithSingleNumber() {
        Sub sub = new Sub();
        Double[] numbers = {5.0};
        assertEquals(5.0, sub.getResult(numbers), 0.01);
    }

    @Test
    public void testGetResultWithTwoNumbers() {
        Sub sub = new Sub();
        Double[] numbers = {5.0, 3.0};
        assertEquals(2.0, sub.getResult(numbers), 0.01);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Sub sub = new Sub();
        Double[] numbers = {5.0, 3.0, 2.0, 1.0};
        assertEquals(-1.0, sub.getResult(numbers), 0.01);
    }
}