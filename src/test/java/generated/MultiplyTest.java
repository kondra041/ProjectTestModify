package generated;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {

    @Test
    public void testGetResultWithMultipleNumbers() {
        Multiply multiply = new Multiply();
        Double result = multiply.getResult(2.0, 3.0, 4.0);
        assertEquals(24.0, result);
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Multiply multiply = new Multiply();
        Double result = multiply.getResult(5.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testGetResultWithZero() {
        Multiply multiply = new Multiply();
        Double result = multiply.getResult(0.0, 2.0, 3.0);
        assertEquals(0.0, result);
    }
}