package generated;

import projectTestModify.CalculatorOOPS.Operate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    public void testGetResultWithPositiveNumbers() {
        Operate add = new Add();
        assertEquals(15.0, add.getResult(1.0, 2.0, 3.0, 4.0, 5.0), "Sum of positive numbers should be correct");
    }

    @Test
    public void testGetResultWithNegativeNumbers() {
        Operate add = new Add();
        assertEquals(-15.0, add.getResult(-1.0, -2.0, -3.0, -4.0, -5.0), "Sum of negative numbers should be correct");
    }

    @Test
    public void testGetResultWithMixedNumbers() {
        Operate add = new Add();
        assertEquals(0.0, add.getResult(-1.0, 1.0, -2.0, 2.0, -3.0, 3.0), "Sum of mixed numbers should be zero");
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Operate add = new Add();
        assertEquals(42.0, add.getResult(42.0), "Single number should return itself");
    }

    @Test
    public void testGetResultWithNoNumbers() {
        Operate add = new Add();
        assertEquals(0.0, add.getResult(), "Sum with no numbers should be zero");
    }
}