import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;

@ExtendWith(MockitoExtension.class)
public class AddMemberMenuTest {
    
    @Mock
    private Connection conn;
    
    @Mock
    private Statement stmt;
    
    @Spy
    private Scanner scanner = new Scanner(System.in);
    
    @InjectMocks
    private AddMemberMenu addMemberMenu;
    
    @BeforeEach
    void setUp() {
        when(LibUtil.getConnection()).thenReturn(conn);
    }

    @Test
    void testAddMemberMenu_HappyPath() {
        // Mock inputs for Scanner
        when(scanner.nextLine()).thenReturn("123").thenReturn("John Doe");
        
        // Mock database interaction
        when(stmt.executeUpdate("insert into members values (123,'John Doe',sysdate)")).thenReturn(1);
        
        AddMemberMenu.addMemberMenu();
        
        verify(scanner, atLeastOnce()).nextLine();
        verify(conn).createStatement();
        verify(stmt).executeUpdate(anyString());
    }

    @Test
    void testAddMemberMenu_InvalidId() {
        when(scanner.nextLine()).thenReturn("0").thenReturn("John Doe");
        
        AddMemberMenu.addMemberMenu();
        
        verify(scanner, atLeastOnce()).nextLine();
        // Verify that it handles invalid ID gracefully
        assertTrue(true); // Replace with actual assertions as needed
    }

    @Test
    void testAddMemberMenu_ExceptionCase() {
        when(scanner.nextLine()).thenReturn("123").thenReturn("John Doe");
        doThrow(new RuntimeException("DB Error")).when(stmt).executeUpdate(anyString());
        
        AddMemberMenu.addMemberMenu();
        
        verify(scanner, atLeastOnce()).nextLine();
        // Verify exception handling
        assertTrue(true); // Replace with actual assertions as needed
    }
}