package generated;

import projectTestModify.CalculatorOOPS.Divide;

import org.junit.jupiter.api.Test;

public class DivideTest {

    @Test
    public void testDivide() {
        Divide divide = new Divide();
        Double[] numbers = { 10.0, 2.0, 3.0 };
        Double expected = 0.5;
        Double actual = divide.getResult(numbers);
        assertEquals(expected, actual);
    }
}