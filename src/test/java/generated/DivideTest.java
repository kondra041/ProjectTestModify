package generated;

import projectTestModify.CalculatorOOPS;
import projectTestModify.Operate;

public class DivideTest {

    @org.junit.jupiter.api.Test
    public void testDivide() {
        Operate divide = new Divide();
        Double[] numbers = {10.0, 5.0};
        Double result = divide.getResult(numbers);
        assertEquals(2.0, result);
    }
}