import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.TestMethod;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;

class AddMemberMenuTest {

    @Mock
    private Connection conn;
    
    @Mock
    private Statement stmt;
    
    @InjectMocks
    private AddMemberMenu addMemberMenu;
    
    @TestMethod
    void testAddMember_Success() throws SQLException {
        // Setup mock behavior
        when(conn.createStatement()).thenReturn(stmt);
        doNothing().when(stmt).executeUpdate("insert into members values (1, 'test', sysdate)");
        
        Member m = new Member();
        m.setMemberId(1);
        m.setMemberName("test");
        
        // Execute method under test
        AddMemberMenu.addMember(m);
        
        // Verify interactions
        verify(stmt).executeUpdate("insert into members values (1, 'test', sysdate)");
        verify(conn).commit();
        verify(conn).close();
    }

    @TestMethod
    void testAddMember_Failure() throws SQLException {
        when(conn.createStatement()).thenReturn(stmt);
        doThrow(new SQLException()).when(stmt).executeUpdate(anyString());
        
        Member m = new Member();
        m.setMemberId(1);
        m.setMemberName("test");
        
        AddMemberMenu.addMember(m);
        
        verify(stmt).executeUpdate("insert into members values (1, 'test', sysdate)");
        verify(conn).rollback();
        verify(conn).close();
    }

    @TestMethod
    void testAddMember_Null() {
        when(conn.createStatement()).thenReturn(stmt);
        
        AddMemberMenu.addMember(null);
        
        verifyNoInteractions(conn);
    }
    
    // Initialize mocks before each test method
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }
}