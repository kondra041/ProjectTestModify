package generated;

import projectTestModify.passwordGenerator.Alphabet;
import projectTestModify.passwordGenerator.Generator;
import projectTestModify.passwordGenerator.Password;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GeneratorTest {
    private Generator generator;
    private InputStream systemIn;

    @BeforeEach
    public void setUp() {
        systemIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(systemIn);
    }

    @Test
    public void testGeneratePassword() {
        Alphabet alphabet = mock(Alphabet.class);
        when(alphabet.getAlphabet()).thenReturn("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()");
        generator = new Generator(alphabet);

        int length = 10;
        Password password = generator.GeneratePassword(length);

        assertNotNull(password);
        assertEquals(length, password.getPassword().length());
    }

    @Test
    public void testRequestPassword() {
        String input = "yes\nno\nno\nno\n10\n4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        generator = new Generator(new Scanner(System.in));
        generator.mainLoop();
    }
}