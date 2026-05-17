import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.CalculatorOOPS.Add;
import projectTestModify.CalculatorOOPS.Operate;

@ExtendWith(MockitoExtension.class)
public class AddTest {

    @InjectMocks
    private Add add;

    @Test
    public void testSumWithNoNumbers() {
        double result = add.getResult();
        assertEquals(0.0, result);
    }

    @Test
    public void testSumWithOneNumber() {
        double number = 5.0;
        double result = add.getResult(number);
        assertEquals(number, result);
    }

    @Test
    public void testSumWithMultipleNumbers() {
        Double[] numbers = {1.0, 2.0, 3.0};
        double expectedSum = Arrays.stream(numbers).sum();
        double result = add.getResult(numbers);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testSumWithNegativeNumbers() {
        Double[] numbers = {-1.5, -2.5};
        double expectedSum = Arrays.stream(numbers).sum();
        double result = add.getResult(numbers);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testSumIncludingZero() {
        Double[] numbers = {0.0, 3.5, 4.5};
        double expectedSum = Arrays.stream(numbers).sum();
        double result = add.getResult(numbers);
        assertEquals(expectedSum, result);
    }
}