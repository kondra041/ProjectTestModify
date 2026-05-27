package generated;

import projectTestModify.CalculatorOOPS.Sub;
import projectTestModify.CalculatorOOPS.Operate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SubTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        Operate sub = new Sub();
        
        Double result = sub.getResult(10.0, 2.0);
        assertEquals(8.0, result);
        
        result = sub.getResult(5.0, 2.0, 3.0);
        assertEquals(0.0, result);
    }
}