package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Modulus;

class ModulusTest {

    @Test
    void testModulusWithTwoNumbers() {
        Modulus mod = new Modulus();
        Double result = mod.getResult(10.0, 3.0);
        assertEquals(1.0, result);
    }

    @Test
    void testModulusWithMultipleNumbers() {
        Modulus mod = new Modulus();
        Double result = mod.getResult(new Double[]{15.0, 4.0, 2.0});
        assertEquals(1.0, result);
    }

    @Test
    void testModulusWithZero() {
        Modulus mod = new Modulus();
        assertThrows(ArithmeticException.class, () -> mod.getResult(5.0, 0.0));
    }

    @Test
    void testNegativeNumbersModulus() {
        Modulus mod = new Modulus();
        Double result = mod.getResult(-5.0, 3.0);
        assertEquals(-2.0, result);
    }

    @Test
    void testNonIntegerValues() {
        Modulus mod = new Modulus();
        Double result = mod.getResult(7.5, 2.0);
        assertEquals(1.5, result);
    }

    @Test
    void testSingleNumberModulus() {
        Modulus mod = new Modulus();
        Double result = mod.getResult(42.0);
        assertEquals(42.0, result);
    }

    @Test
    void testEmptyNumbersArray() {
        Modulus mod = new Modulus();
        assertThrows(IndexOutOfBoundsException.class, () -> mod.getResult());
    }
}