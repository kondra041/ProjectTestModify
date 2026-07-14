package generated;

import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Modulus;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModulusTest {
    private Operate modulus;

    @BeforeEach
    public void setup() {
        modulus = new Modulus();
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Double result = modulus.getResult(5.0);
        assertEquals(5.0, result);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Double result = modulus.getResult(10.0, 3.0, 2.0);
        assertEquals(1.0, result);
    }

    @Test
    public void testGetResultWithZeroDivisor() {
        assertThrows(ArithmeticException.class, () -> modulus.getResult(10.0, 0.0));
    }
}