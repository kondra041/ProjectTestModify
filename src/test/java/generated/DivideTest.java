package generated;

import projectTestModify.CalculatorOOPS.Divide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivideTest {
    @Test
    public void testGetResult() {
        Divide divide = new Divide();
        assertEquals(2.0, divide.getResult(16.0, 8.0), 0.001);
        assertEquals(5.0, divide.getResult(50.0, 10.0), 0.001);
    }
}