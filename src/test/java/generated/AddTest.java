package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AddTest {

    @Test
    public void testGetResultWithOneNumber() {
        Add add = new Add();
        Double result = add.getResult(10.0);
        assertEquals(10.0, result);
    }

    @Test
    public void testGetResultWithMultipleNumbers() {
        Add add = new Add();
        Double result = add.getResult(5.0, 3.0, 2.0);
        assertEquals(10.0, result);
    }
}