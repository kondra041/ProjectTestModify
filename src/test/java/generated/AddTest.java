package generated;

import projectTestModify.CalculatorOOPS.Add;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddTest {

    @Test
    public void testGetResultWithSingleNumber() {
        Add add = new Add();
        Double result = add.getResult(1.0);
        assertEquals(1.0, result, 0.01);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Add add = new Add();
        Double result = add.getResult(1.0, 2.0, 3.0);
        assertEquals(6.0, result, 0.01);
    }

    @Test
    public void testGetResultWithNoNumbers() {
        Add add = new Add();
        Double result = add.getResult();
        assertEquals(0.0, result, 0.01);
    }
}