package generated;

import projectTestModify.CalculatorOOPS.Divide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DivideTest {

    @Test
    public void testGetResultWithTwoNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(20.0, 5.0);
        assertEquals(4.0, result, 0.01);
    }

    @Test
    public void testGetResultWithThreeNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(60.0, 10.0, 2.0);
        assertEquals(3.0, result, 0.01);
    }

    @Test
    public void testGetResultWithFourNumbers() {
        Divide divide = new Divide();
        Double result = divide.getResult(80.0, 4.0, 2.0, 5.0);
        assertEquals(1.0, result, 0.01);
    }
}