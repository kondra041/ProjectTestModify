package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectTestModify.CalculatorOOPS.Modulus;
import projectTestModify.CalculatorOOPS.Operate;

public class ModulusTest {

    @Test
    public void testGetResult() {
        Operate modulus = new Modulus();
        
        assertEquals(0.0, modulus.getResult(10.0, 2.0, 3.0));
        assertEquals(1.0, modulus.getResult(15.0, 4.0, 2.0));
        assertEquals(0.0, modulus.getResult(9.0, 3.0, 3.0));
        assertEquals(2.0, modulus.getResult(17.0, 5.0, 3.0));
    }
}