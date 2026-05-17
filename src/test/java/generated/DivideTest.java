package generated;

import static org.junit.jupiter.api.Assertions.assertAllClose;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import projectTestModify.CalculatorOOPS.Divide;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DivideTest {

    @ParameterizedTest
    @ValueSource(doubles = {16.0, 4.0})
    void testNormalDivision(Double... numbers) {
        Divide divide = new Divide();
        Double result = divide.getResult(numbers);
        assertAllClose(4.0, result, 0.001);
    }

    @Test
    void testDivideByZero() {
        Divide divide = new Divide();
        assertThrows(ArithmeticException.class, () -> {
            divide.getResult(5.0, 0.0);
        });
    }
}