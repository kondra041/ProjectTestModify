package generated;

import projectTestModify.CalculatorOOPS.Divide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {
    @Test
    public void testGetResult() {
        Divide divide = new Divide();
        Double result = divide.getResult(20.0, 5.0, 2.0);
        assertEquals(2.0, result);
    }
}