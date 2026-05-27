package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Multiply;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyTest {

    @Test
    void testGetResult() {
        Multiply multiply = new Multiply();

        assertAll(
                () -> assertEquals(1.0, multiply.getResult()),
                () -> assertEquals(2.0, multiply.getResult(2.0)),
                () -> assertEquals(6.0, multiply.getResult(2.0, 3.0)),
                () -> assertEquals(24.0, multiply.getResult(2.0, 3.0, 4.0)),
                () -> assertEquals(120.0, multiply.getResult(2.0, 3.0, 4.0, 5.0))
        );
    }
}