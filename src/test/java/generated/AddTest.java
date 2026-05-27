package generated;

import projectTestModify.CalculatorOOPS.Add;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        Add add = new Add();
        assertEquals(6.0, add.getResult(1.0, 2.0, 3.0));
        assertEquals(-4.5, add.getResult(-2.5, -2.0));
        assertEquals(0.0, add.getResult());
    }
}