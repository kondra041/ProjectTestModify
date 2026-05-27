package generated;

import projectTestModify.CalculatorOOPS.Add;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    public void testAdd() {
        Add add = new Add();
        Double expected = 6.0;
        Double actual = add.getResult(2.0, 4.0);
        assertEquals(expected, actual);
    }
}