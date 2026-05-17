import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;
import projectTestModify.libraryManagement.LibUtil;
import java.util.Scanner;

class TestAddMemberMenu {
    
    @Test
    void testAddMemberMenu() {
        // Mock setup
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);

        // Setup LibUtil.getConnection to return the mock connection
        when(LibUtil.getConnection()).thenReturn(mockConnection);

        // Setup statement.executeUpdate to return 1 (success)
        when(mockStatement.executeUpdate("insert into members values (?,?,sysdate)", 
            anyString())).thenReturn(1);

        try {
            AddMemberMenu.addMemberMenu();
            
            // Verify that addMember was called with the correct arguments
            verify(AddMemberMenu.class).addMember(any(Member.class));
            verify(mockConnection).commit();
            
            System.out.println("Test passed successfully");
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            fail(e);
        }
    }
}