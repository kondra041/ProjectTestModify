package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Add;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    public void testGetResult() {
        Add add = new Add();
        assertEquals(6.0, add.getResult(1.0, 2.0, 3.0));
        assertEquals(0.0, add.getResult());
        assertEquals(5.5, add.getResult(5.5));
    }
}