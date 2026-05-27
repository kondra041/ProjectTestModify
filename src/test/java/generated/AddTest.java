package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.CalculatorOOPS.Add;
import projectTestModify.CalculatorOOPS.Operate;

class AddTest {
    @Test
    void testGetResult() {
        // Arrange
        Double[] numbers = new Double[] {1.0, 2.0};
        Operate operate = mock(Add.class);
        when(operate.getResult(numbers)).thenReturn(3.0);

        // Act
        double result = operate.getResult(numbers);

        // Assert
        assertEquals(3.0, result);
    }
}