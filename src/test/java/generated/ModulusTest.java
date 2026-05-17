package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Modulus;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModulusTest {

    @Test
    public void testGetResult() {
        Modulus modulus = new Modulus();
        
        assertEquals(0.0, modulus.getResult(10.0, 2.0, 3.0));
        assertEquals(1.0, modulus.getResult(13.0, 5.0, 4.0));
        assertEquals(2.0, modulus.getResult(20.0, 7.0, 3.0));
    }
}