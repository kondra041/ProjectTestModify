import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.CalculatorOOPS.CalculatorOperations;

@ExtendWith(MockitoExtension.class)
public class TestMultiply {
    
    @Mock
    private CalculatorOperations operations;

    @InjectMocks
    private Multiply multiply;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        double[] numbers = {2.0, 3.0};
        when(operations.getResult(numbers)).thenReturn(6.0);

        double result = multiply.getResult(2.0, 3.0);
        
        assertEquals(6.0, result, "Should return correct multiplication result");
        verify(operations).getResult(numbers);
    }

    @Test
    void multiplyThreePositiveNumbers() {
        double[] numbers = {1.0, 2.0, 3.0};
        when(operations.getResult(numbers)).thenReturn(6.0);

        double result = multiply.getResult(1.0, 2.0, 3.0);
        
        assertEquals(6.0, result, "Should return correct multiplication result");
        verify(operations).getResult(numbers);
    }

    @Test
    void multiplyWithZero() {
        double[] numbers = {5.0, 0.0};
        when(operations.getResult(numbers)).thenReturn(0.0);

        double result = multiply.getResult(5.0, 0.0);
        
        assertEquals(0.0, result, "Should handle multiplication with zero");
        verify(operations).getResult(numbers);
    }

    @Test
    void handleEmptyInput() {
        when(operations.getResult()).thenReturn(1.0);

        double result = multiply.getResult();
        
        assertEquals(1.0, result, "Should handle empty input gracefully");
        verify(operations).getResult();
    }
}