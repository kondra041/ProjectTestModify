package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Add;

public class AddTest {

    @Test
    void testGetResult() {
        Add add = new Add();
        assertEquals(6.0, add.getResult(2.0, 3.0, 1.0));
        assertEquals(0.0, add.getResult());
        assertEquals(10.0, add.getResult(5.0, 5.0));
    }

}