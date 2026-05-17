package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.emailgenerator.Email;

import java.util.Scanner;

public class EmailTest {

    private Email email;

    @BeforeEach
    public void setUp() {
        // Mocking user input for department selection
        System.setIn(new java.io.ByteArrayInputStream("1\n".getBytes()));
        email = new Email("John", "Doe");
    }

    @Test
    public void testEmailCreation() {
        assertEquals("john.doe@drngpit.ac.in", email.getEmail());
    }

    @Test
    public void testDepartmentSelection() {
        assertEquals("sales", email.getDepartment());
    }

    @Test
    public void testPasswordGeneration() {
        assertNotNull(email.getPassword());
        assertEquals(8, email.getPassword().length());
    }

    @Test
    public void testVerificationCodeGeneration() {
        assertNotNull(email.getVcode());
        assertEquals(5, email.getVcode().length());
    }

    @Test
    public void testShowInfo() {
        String expected = "Name : JohnDoe\nOfficial email : john.doe@drngpit.ac.in\nDepartment : Sales";
        assertEquals(expected, email.showInfo());
    }
}