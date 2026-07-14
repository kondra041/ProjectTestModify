package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {

    @Test
    public void testGetResult() {
        Multiply multiply = new Multiply();
        
        assertEquals(1.0, multiply.getResult());
        assertEquals(6.0, multiply.getResult(2.0, 3.0));
        assertEquals(45.0, multiply.getResult(3.0, 5.0, 3.0));
    }
}