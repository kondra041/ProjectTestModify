package generated;

import projectTestModify.CalculatorOOPS.Add;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddTest {
    private Add add;

    @BeforeEach
    public void setUp() {
        add = new Add();
    }

    @Test
    public void testGetResultWithPositiveNumbers() {
        Double result = add.getResult(1.0, 2.0, 3.0);
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testGetResultWithNegativeNumbers() {
        Double result = add.getResult(-1.0, -2.0, -3.0);
        assertEquals(-6.0, result, 0.001);
    }

    @Test
    public void testGetResultWithMixedNumbers() {
        Double result = add.getResult(1.0, -2.0, 3.0);
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testGetResultWithNoNumbers() {
        Double result = add.getResult();
        assertEquals(0.0, result, 0.001);
    }
}