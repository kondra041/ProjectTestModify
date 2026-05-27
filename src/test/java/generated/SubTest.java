package generated;

import projectTestModify.CalculatorOOPS.Operate;
import static org.junit.jupiter.api.Assertions.*;

public class SubTest extends OperateTest {

    @Override
    Operate getOperate() {
        return new Sub();
    }

    @Test
    void testSub() {
        Double[] numbers = {5.0, 3.0, 2.0};
        Double expected = 0.0;
        Double actual = operate.getResult(numbers);
        assertEquals(expected, actual);
    }
}