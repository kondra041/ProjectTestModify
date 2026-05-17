package generated;

import projectTestModify.emailgenerator.Email;
import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmailTest {

    @Test
    public void testRandomPass() {
        Email email = new Email("John", "Doe");
        String password = email.getPassword();
        assertNotNull(password);
        assertEquals(8, password.length());
        assertTrue(password.matches("[A-Z1-9!@#$%]{8}"));
    }

    @Test
    public void testVcode() {
        Email email = new Email("John", "Doe");
        String vCode = email.getVcode();
        assertNotNull(vCode);
        assertEquals(5, vCode.length());
        assertTrue(vCode.matches("[1-9]{5}"));
    }

    @Test
    public void testSetPassword() {
        Email email = new Email("John", "Doe");
        String newPassword = "NewSecurePass123!";
        email.setPassword(newPassword);
        assertEquals(newPassword, email.getPassword());
    }

    @Test
    public void testGetDept() {
        Email email = new Email("John", "Doe");
        email.setDepartment("dev");
        assertEquals("Developers", email.getDept(email.getDepartment()));
        email.setDepartment("acc");
        assertEquals("Accounts", email.getDept(email.getDepartment()));
        email.setDepartment("sales");
        assertEquals("Sales", email.getDept(email.getDepartment()));
    }

    @Test
    public void testShowInfo() {
        Email email = new Email("John", "Doe");
        String info = email.showInfo();
        assertNotNull(info);
        assertTrue(info.contains("Name : JohnDoe"));
        assertTrue(info.contains("Official email : johndoe."));
    }
}