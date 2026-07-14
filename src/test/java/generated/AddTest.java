package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Add;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    public void testGetResult() {
        Add add = new Add();
        Double result = add.getResult(1.0, 2.0, 3.0);
        assertEquals(6.0, result);
    }

    @Test
    public void testGetResultWithZeroNumbers() {
        Add add = new Add();
        Double result = add.getResult();
        assertEquals(0.0, result);
    }

    @Test
    public void testGetResultWithNegativeNumbers() {
        Add add = new Add();
        Double result = add.getResult(-1.0, -2.0, -3.0);
        assertEquals(-6.0, result);
    }
}