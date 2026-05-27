package generated;

import projectTestModify.CalculatorOOPS.Modulus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModulusTest {

    @Test
    public void testModulus() {
        Modulus modulus = new Modulus();
        assertEquals(5.0, modulus.getResult(10.0, 3.0));
    }
}