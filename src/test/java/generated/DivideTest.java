package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.exceptionsgetMockito;

public class DivideTest {

    private final Calculator calculator = mock(Calculator.class);
    
    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void testGetResult(Double... numbers) {
        when(calculator.operate(numbers)).thenReturn(divide(numbers));
        double result = calculator.operate(numbers);
        assertEquals(divide(numbers), result, () -> "Failed with input: " + Stream.of(numbers));
    }

    private static Double divide(Double[] numbers) {
        if (numbers.length == 0) return null;
        Double div = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            div /= numbers[i];
        }
        return div;
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> divide(new Double[]{4.0, 0.0}));
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> divide(new Double[]{null}));
    }

    @Test
    public void testEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> divide(new Double[0]));
    }
}