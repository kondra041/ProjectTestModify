package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class TestEmail {
    
    @InjectMocks
    private Email email;

    @BeforeEach
    void setUp() {
        email = new Email("John", "Doe");
    }

    @Test
    @DisplayName("Test Set Password")
    void testSetPassword() {
        email.setPassword("newpassword123");
        assertEquals("newpassword123", email.getPassword());
    }

    @Test
    @DisplayName("Test Show Info Method")
    void testShowInfo() {
        String expected = "Name : John Doe\nOfficial email : john.doe@drngpit.ac.in\nDepartment : Developers";
        assertEquals(expected, email.showInfo());
    }

    @Test
    @DisplayName("Test Set Email")
    void testSetEmail() {
        email.setEmail("test@example.com");
        assertEquals("test@example.com", email.getEmail());
    }

    @Test
    @DisplayName("Test Random Password Length")
    void testRandomPassLength() {
        String password = email.randomPass(8);
        assertEquals(8, password.length());
    }

    @Test
    @DisplayName("Test Department Validation")
    void testDepartmentValidation() {
        when(email.setDepartment()).thenReturn("dev");
        assertEquals("Developers", email.getDept("dev"));
    }
}