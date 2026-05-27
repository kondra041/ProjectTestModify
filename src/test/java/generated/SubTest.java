package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.Operate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubTest {

    @Test
    void testSingleElement() {
        Operate sub = new Sub();
        assertEquals(5.0, sub.getResult(5.0));
    }

    @Test
    void testTwoElements() {
        Operate sub = new Sub();
        assertEquals(3.0, sub.getResult(5.0, 2.0));
    }

    @Test
    void testMultipleElements() {
        Operate sub = new Sub();
        assertEquals(-1.0, sub.getResult(5.0, 2.0, 3.0, 4.0));
    }

    @Test
    void testNegativeNumbers() {
        Operate sub = new Sub();
        assertEquals(-8.0, sub.getResult(5.0, 10.0, 7.0));
    }

    @Test
    void testMixedPositiveAndNegativeNumbers() {
        Operate sub = new Sub();
        assertEquals(2.0, sub.getResult(5.0, -1.0, 2.0, -4.0));
    }
}