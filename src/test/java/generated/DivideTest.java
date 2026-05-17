package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Divide;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {

    @Test
    public void testGetResult() {
        Divide divide = new Divide();
        
        Double result1 = divide.getResult(8.0, 2.0);
        assertEquals(4.0, result1);
        
        Double result2 = divide.getResult(100.0, 5.0, 2.0);
        assertEquals(10.0, result2);
        
        Double result3 = divide.getResult(10.0, 2.0, 0.5);
        assertEquals(40.0, result3);
    }
}