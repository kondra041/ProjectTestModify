package generated;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModulusTest {

    private Modulus modulus;

    @BeforeEach
    public void setUp() {
        modulus = new Modulus();
    }

    @Test
    public void testGetResultWithTwoNumbers() {
        Double result = modulus.getResult(10.0, 3.0);
        assertEquals(1.0, result);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Double result = modulus.getResult(24.0, 5.0, 2.0);
        assertEquals(0.0, result);
    }

    @Test
    public void testGetResultWithOneNumber() {
        Double result = modulus.getResult(15.0);
        assertEquals(15.0, result);
    }

    @Test
    public void testGetResultWithZeroAsModulus() {
        assertThrows(ArithmeticException.class, () -> {
            modulus.getResult(20.0, 0.0);
        });
    }
}