package generated;

import projectTestModify.CalculatorOOPS.Multiply;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MultiplyTest {

    @Test
    public void testGetResultWithSingleNumber() {
        Multiply multiply = new Multiply();
        Double number = 2.5;
        assertEquals(number, multiply.getResult(number));
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Multiply multiply = new Multiply();
        Double[] numbers = {1.0, 2.0, 3.0};
        assertEquals(6.0, multiply.getResult(numbers));
    }
}