package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Sub;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubTest {

    @Test
    public void testGetResult() {
        Sub sub = mock(Sub.class);
        when(sub.getResult(10.0, 5.0)).thenReturn(5.0);
        assertEquals(5.0, sub.getResult(10.0, 5.0));
    }

    @Test
    public void testGetResultSingleNumber() {
        Sub sub = new Sub();
        assertEquals(Double.POSITIVE_INFINITY, sub.getResult());
    }

    @Test
    public void testGetResultNegativeNumbers() {
        Sub sub = new Sub();
        assertThrows(ArithmeticException.class, () -> sub.getResult(-10.0));
    }
}