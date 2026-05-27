import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.CalculatorOOPS.Operate;
import projectTestModify.CalculatorOOPS.Modulus;

@ExtendWith(MockitoExtension.class)
public class ModulusTest {

    @InjectMocks
    private Modulus modulus;

    @Test
    public void testMultipleNumbers() {
        assertAll(
            () -> assertEquals(2.0, modulus.getResult(20.0, 5.0, 3.0)),
            () -> assertEquals(10.0, modulus.getResult(10.0)),
            () -> assertEquals(-1.0, modulus.getResult(-10.0, 3.0))
        );
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> modulus.getResult(10.0, 0.0));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(5.0, modulus.getResult(5.0));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> modulus.getResult(null));
    }
}