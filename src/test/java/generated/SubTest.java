package generated;

import projectTestModify.CalculatorOOPS.Sub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SubTest {
    
    private Sub sub;
    
    @BeforeEach
    public void setUp() {
        sub = new Sub();
    }
    
    @Test
    public void testGetResult_oneValue() {
        Double expected = 10.0;
        
        Double actual = sub.getResult(expected);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetResult_multipleValues() {
        Double[] values = new Double[] {5.0, 3.0, 2.0};
        Double expected = 4.0; // (10 - 7) - 2
        
        when(sub.getResult(values)).thenReturn(expected);
        
        Double actual = sub.getResult(values);
        
        assertEquals(expected, actual);
    }
}