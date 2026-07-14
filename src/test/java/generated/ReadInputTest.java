package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.CalculatorOOPS.ReadInput;
import java.util.Scanner;

public class ReadInputTest {

    @Test
    public void testRead() {
        // Create a mock Scanner object
        Scanner mockScanner = mock(Scanner.class);

        // Define the behavior of the mock Scanner
        when(mockScanner.nextLine()).thenReturn("4*3/2");

        // Replace the real System.in with the mock Scanner
        System.setIn(new java.io.InputStream() {
            private final byte[] c = "4*3/2\n".getBytes();
            private int i = 0;

            @Override
            public int read() {
                return i < c.length ? c[i++] : -1;
            }
        });

        // Call the method under test
        String result = ReadInput.read();

        // Verify that the mock Scanner was used correctly
        verify(mockScanner).nextLine();
        verify(mockScanner).close();

        // Assert that the result is as expected
        assertEquals("4*3/2", result);
    }
}