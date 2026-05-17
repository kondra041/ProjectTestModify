package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    @Test
    public void testCharTypeUpperCase() {
        Password password = new Password("A");
        assertEquals(1, password.CharType('A'));
    }

    @Test
    public void testCharTypeLowerCase() {
        Password password = new Password("a");
        assertEquals(2, password.CharType('a'));
    }

    @Test
    public void testCharTypeDigit() {
        Password password = new Password("1");
        assertEquals(3, password.CharType('1'));
    }

    @Test
    public void testCharTypeSymbol() {
        Password password = new Password("@");
        assertEquals(4, password.CharType('@'));
    }
}