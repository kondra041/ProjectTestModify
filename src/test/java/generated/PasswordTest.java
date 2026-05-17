package generated;

import projectTestModify.passwordGenerator.Password;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    @ParameterizedTest
    @ValueSource(strings = {"StrongPassword1!", "Weakpassword", "OnlyNumbers12345678", "@@@@@@@@@@@@"})
    public void testPasswordStrength(String password) {
        Password pwdObj = new Password(password);
        int score = pwdObj.PasswordStrength();
        String resultMessage = pwdObj.calculateScore();
        assertNotNull(resultMessage);
    }
}