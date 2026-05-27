package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Multiply;

public class MultiplyTest {

    @Test
    public void testGetResultWithPositiveNumbers() {
        Operate multiply = new Multiply();
        assertEquals(6.0, multiply.getResult(2.0, 3.0), "Multiplication of positive numbers failed");
    }

    @Test
    public void testGetResultWithNegativeAndPositiveNumbers() {
        Operate multiply = new Multiply();
        assertEquals(-6.0, multiply.getResult(-2.0, 3.0), "Multiplication with negative and positive number failed");
    }

    @Test
    public void testGetResultWithAllZeroes() {
        Operate multiply = new Multiply();
        assertEquals(0.0, multiply.getResult(0.0, 0.0, 0.0), "Multiplication of all zeroes failed");
    }

    @Test
    public void testGetResultWithSingleNumber() {
        Operate multiply = new Multiply();
        assertEquals(5.0, multiply.getResult(5.0), "Multiplication with a single number failed");
    }

    @Test
    public void testGetResultWithMultipleNumbersIncludingZero() {
        Operate multiply = new Multiply();
        assertEquals(0.0, multiply.getResult(3.0, 4.0, 0.0), "Multiplication including zero failed");
    }
}