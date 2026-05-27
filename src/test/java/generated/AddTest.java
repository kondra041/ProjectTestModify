package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import projectTestModify.CalculatorOOPS.Add;

public class AddTest {

    @Test
    public void testGetResult() {
        Double result = new Add().getResult(1.0, 2.0, 3.0);
        assertEquals(6.0, result, "Sum of 1.0 + 2.0 + 3.0 should be 6.0");
    }
}