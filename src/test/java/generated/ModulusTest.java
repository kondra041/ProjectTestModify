package generated;

import projectTestModify.CalculatorOOPS.Modulus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ModulusTest {

    @Test
    public void testGetResultWithTwoNumbers() {
        Modulus modulus = new Modulus();
        Double result = modulus.getResult(10.0, 3.0);
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testGetResultWithThreeNumbers() {
        Modulus modulus = new Modulus();
        Double result = modulus.getResult(15.0, 4.0, 2.0);
        assertEquals(1.0, result, 0.001);
    }

    @Test
    public void testGetResultWithZeroDivisor() {
        Modulus modulus = new Modulus();
        assertThrows(ArithmeticException.class, () -> {
            modulus.getResult(10.0, 0.0);
        });
    }
}