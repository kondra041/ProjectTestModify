package generated;

import projectTestModify.CalculatorOOPS.Sub;
import static org.junit.jupiter.api.Assertions.*;

public class SubTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        Sub sub = new Sub();

        Double[] numbers1 = {5.0, 3.0};
        assertEquals(2.0, sub.getResult(numbers1));

        Double[] numbers2 = {7.0, 2.0, 1.0};
        assertEquals(4.0, sub.getResult(numbers2));

        Double[] numbers3 = {};
        assertThrows(IndexOutOfBoundsException.class, () -> sub.getResult(numbers3));
    }
}