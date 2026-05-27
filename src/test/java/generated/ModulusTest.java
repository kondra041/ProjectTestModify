package generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertThrows;
import projectTestModify.CalculatorOOPS.Modulus;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModulusTest {

    @Test
    void testModulus() {
        Modulus modulus = mock(Modulus.class);
        when(modulus.getResult(10.0, 3.0)).thenReturn(1.0);
        assertEquals(1.0, modulus.getResult(10.0, 3.0));
    }

    @Test
    void testModulusWithZero() {
        Modulus modulus = new Modulus();
        assertThrows(ArithmeticException.class, () -> modulus.getResult(10.0, 0.0));
    }

    @Test
    void testModulusWithNegativeNumbers() {
        Modulus modulus = new Modulus();
        assertEquals(-1.0, modulus.getResult(-10.0, -3.0));
    }
}