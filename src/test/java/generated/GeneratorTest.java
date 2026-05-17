package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.passwordGenerator.Alphabet;
import projectTestModify.passwordGenerator.Password;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GeneratorTest {

    private Generator generator;
    private Scanner mockScanner;

    @BeforeEach
    public void setUp() {
        mockScanner = mock(Scanner.class);
        generator = new Generator(mockScanner);
    }

    @Test
    public void testGeneratePassword() {
        Alphabet alphabet = new Alphabet(true, true, true, true);
        Generator spyGenerator = spy(new Generator(alphabet));

        when(spyGenerator.GeneratePassword(anyInt())).thenCallRealMethod();
        String result = spyGenerator.GeneratePassword(10);

        assertEquals(10, result.length());
    }

    @Test
    public void testGeneratePasswordWithMockedRandom() {
        Alphabet alphabet = new Alphabet(true, true, true, true);
        Generator spyGenerator = spy(new Generator(alphabet));

        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(anyInt())).thenReturn(0);

        // Inject the mocked Random instance into GeneratePassword method
        String result = spyGenerator.GeneratePassword(10);

        assertEquals(10, result.length());
    }
}