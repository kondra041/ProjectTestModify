package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GeneratorTest {

    @Mock
    private Scanner mockScanner;

    private Generator generator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        generator = new Generator(mockScanner);
    }

    @Test
    public void testIsIncludeYes() {
        when(mockScanner.nextLine()).thenReturn("yes");
        boolean result = generator.isInclude("yes");
        assertEquals(true, result);
    }

    @Test
    public void testIsIncludeNo() {
        when(mockScanner.nextLine()).thenReturn("no");
        boolean result = generator.isInclude("no");
        assertEquals(false, result);
    }

    @Test
    public void testIsIncludeIncorrect() {
        when(mockScanner.nextLine()).thenReturn("incorrect");
        boolean result = generator.isInclude("incorrect");
        assertEquals(false, result);
    }
}