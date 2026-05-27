package generated;

import projectTestModify.CalculatorOOPS;
import static org.junit.jupiter.api.Assertions.*;

public class SubTest {

    @Test
    public void testSub() {
        CalculatorOOPS calculator = new CalculatorOOPS();
        Double result = calculator.sub(5.0, 3.0, 2.0);
        assertEquals(0.0, result);
    }
}