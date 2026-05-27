package generated;

import projectTestModify.CalculatorOOPS.Divide;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTest {

    @Test
    public void testDivide() {
        Divide divide = new Divide();
        assertEquals(1.0, divide.getResult(2.0, 2.0));
        assertEquals(4.0, divide.getResult(16.0, 4.0, 1.0));
        assertEquals(-5.0, divide.getResult(-100.0, -20.0, 2.0));
    }
}