package generated;

import projectTestModify.CalculatorOOPS.Divide;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {

    @org.junit.jupiter.api.Test
    void testGetResult() {
        Divide divide = new Divide();
        Double result = divide.getResult(4.0, 2.0);
        assertEquals(2.0, result);
    }
}