package generated;

import projectTestModify.CalculatorOOPS.Operate;
import org.junit.jupiter.api.Test;

class ModulusTest {

    @Test
    void testSingleElement() {
        Operate modulus = new Modulus();
        assertEquals(5.0, modulus.getResult(5.0), "Single element should return itself");
    }

    @Test
    void testTwoElements() {
        Operate modulus = new Modulus();
        assertEquals(1.0, modulus.getResult(5.0, 4.0), "Modulus of two numbers should be correct");
    }

    @Test
    void testMultipleElements() {
        Operate modulus = new Modulus();
        assertEquals(2.0, modulus.getResult(14.0, 4.0, 3.0), "Modulus with multiple elements should be correct");
    }

    @Test
    void testAllSameElements() {
        Operate modulus = new Modulus();
        assertEquals(0.0, modulus.getResult(8.0, 8.0, 8.0), "All same elements should result in zero");
    }

    @Test
    void testWithZero() {
        Operate modulus = new Modulus();
        assertThrows(ArithmeticException.class, () -> modulus.getResult(10.0, 0.0), "Division by zero should throw exception");
    }
}