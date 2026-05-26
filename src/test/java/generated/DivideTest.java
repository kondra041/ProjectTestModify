package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectTestModify.CalculatorOOPS.Divide;

public class DivideTest {

    @Test
    public void testDivide() {
        Divide divide = new Divide();
        assertEquals(2.0, divide.getResult(10.0, 5.0));
        assertEquals(4.0, divide.getResult(32.0, 4.0, 2.0));
        assertEquals(0.5, divide.getResult(1.0, 2.0));
    }

    @Test
    public void testDivideByOne() {
        Divide divide = new Divide();
        assertEquals(10.0, divide.getResult(10.0, 1.0));
    }

    @Test
    public void testSingleNumber() {
        Divide divide = new Divide();
        assertEquals(5.0, divide.getResult(5.0));
    }
}