package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Add;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {

    @Test
    public void testGetResult() {
        Add add = new Add();
        assertEquals(10.0, add.getResult(5.0, 3.0, 2.0));
        assertEquals(-6.0, add.getResult(-2.0, -4.0));
    }
}