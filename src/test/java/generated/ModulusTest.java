package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ModulusTest {

    @Test
    public void testGetResult() {
        Modulus modulus = new Modulus();
        
        Double result1 = modulus.getResult(10.0, 3.0);
        assertEquals(1.0, result1);
        
        Double result2 = modulus.getResult(25.0, 5.0, 3.0);
        assertEquals(0.0, result2);
        
        Double result3 = modulus.getResult(18.0, 4.0, 3.0, 2.0);
        assertEquals(0.0, result3);
    }
}