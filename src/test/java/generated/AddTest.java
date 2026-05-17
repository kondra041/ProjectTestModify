package generated;

import projectTestModify.CalculatorOOPS.Add;
import org.junit.jupiter.api.Test;

public class AddTest {

    @Test
    public void testGetResult() {
        Add add = new Add();
        
        Double result1 = add.getResult(1.0, 2.0);
        assertEquals(3.0, result1);
        
        Double result2 = add.getResult(1.5, 2.5);
        assertEquals(4.0, result2);
        
        Double result3 = add.getResult(-1.0, 1.0);
        assertEquals(0.0, result3);
    }
}