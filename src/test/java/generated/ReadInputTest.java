package generated;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import projectTestModify.CalculatorOOPS.ReadInput; // assuming ReadInput is in CalculatorOOPS class
import static org.junit.jupiter.api.Assertions.*;

public class ReadInputTest {
    @org.junit.jupiter.api.Test
    public void testRead() {
        String input = "4*3/2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertEquals("4*3/2", ReadInput.read());
    }
}