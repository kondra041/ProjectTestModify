package generated;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import <projectTestModify.CalculatorOOPS>.Add;

public class AddTest {

    @Test
    public void testAdd() {
        Double[] numbers = {1.0, 2.0, 3.0};
        Add add = new Add();
        Double result = add.getResult(numbers);
        assertEquals(6.0, result);
    }

    @Test
    public void testAddNegativeNumbers() {
        Double[] numbers = {-1.0, -2.0, -3.0};
        Add add = new Add();
        Double result = add.getResult(numbers);
        assertEquals(-6.0, result);
    }

    @Test
    public void testAddSingleNumber() {
        Double[] numbers = {5.0};
        Add add = new Add();
        Double result = add.getResult(numbers);
        assertEquals(5.0, result);
    }
}