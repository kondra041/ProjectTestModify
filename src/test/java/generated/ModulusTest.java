package generated;

import projectTestModify.CalculatorOOPS.Modulus;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

public class ModulusTest {

    @org.junit.jupiter.api.Test
    public void testGetResult() {
        Modulus modulus = new Modulus();

        // Test case 1: Basic functionality
        Double result1 = modulus.getResult(10D, 3D);
        assertEquals(1D, result1);

        // Test case 2: Multiple numbers
        Double result2 = modulus.getResult(15D, 4D, 3D);
        assertEquals(3D, result2);

        // Test case 3: Negative numbers
        Double result3 = modulus.getResult(-7D, 3D);
        assertEquals(-1D, result3);

        // Test case 4: Mixed positive and negative numbers
        Double result4 = modulus.getResult(10D, -2D, 5D);
        assertEquals(0D, result4);
    }
}