package generated;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivideTest {

    @Test
    void testGetResult_TwoPositiveNumbers() {
        Operate divide = new Divide();
        Double[] numbers = { 10.0, 2.0 };
        assertEquals(5.0, divide.getResult(numbers));
    }

    @Test
    void testGetResult_TwoNegativeNumbers() {
        Operate divide = new Divide();
        Double[] numbers = { -10.0, -2.0 };
        assertEquals(5.0, divide.getResult(numbers));
    }

    @Test
    void testGetResult_MixedNumbers() {
        Operate divide = new Divide();
        Double[] numbers = { 10.0, -2.0, 1.5 };
        assertEquals(6.666666666666667, divide.getResult(numbers));
    }

    @Test
    void testGetResult_ZeroInArray() {
        Operate divide = new Divide();
        Double[] numbers = { 10.0, 0.0 };
        assertThrows(ArithmeticException.class, () -> divide.getResult(numbers));
    }

    @Test
    void testGetResult_EmptyArray() {
        Operate divide = new Divide();
        Double[] numbers = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> divide.getResult(numbers));
    }
}