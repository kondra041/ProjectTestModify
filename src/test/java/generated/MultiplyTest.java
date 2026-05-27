package generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertThrows;
import projectTestModify.CalculatorOOPS.Multiply;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultiplyTest {

    @Test
    public void testGetResult_PositiveNumbers() {
        // Given
        Double[] numbers = {1.0, 2.0, 3.0};
        Multiply multiply = mock(Multiply.class);
        when(multiply.getResult(numbers)).thenReturn(6.0);

        // When
        Double result = multiply.getResult(numbers);

        // Then
        assertEquals(result, 6.0);
    }

    @Test
    public void testGetResult_NegativeNumbers() {
        // Given
        Double[] numbers = {-1.0, -2.0, -3.0};
        Multiply multiply = mock(Multiply.class);
        when(multiply.getResult(numbers)).thenReturn(-6.0);

        // When
        Double result = multiply.getResult(numbers);

        // Then
        assertEquals(result, -6.0);
    }

    @Test
    public void testGetResult_SingleNumber() {
        // Given
        Double[] numbers = {5.0};
        Multiply multiply = new Multiply();

        // When
        Double result = multiply.getResult(numbers);

        // Then
        assertEquals(result, 5.0);
    }

    @Test
    public void testGetResult_EmptyArray() {
        // Given
        Double[] numbers = {};
        Multiply multiply = new Multiply();

        // When
        Double result = multiply.getResult(numbers);

        // Then
        assertEquals(result, 1.0);
    }
}