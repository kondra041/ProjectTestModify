package generated;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @InjectMocks
    private AddMemberMenu addMemberMenu;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddMember_success() throws Exception {
        Member member = new Member();
        member.setMemberId(1);
        member.setMemberName("John Doe");

        when(LibUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeUpdate(anyString())).thenReturn(1);

        addMemberMenu.addMember(member);

        verify(mockStatement).executeUpdate("insert into members values (1,'John Doe',sysdate)");
        verify(mockConnection).commit();
        verify(mockConnection).close();
    }

    @Test
    public void testAddMember_failure() throws Exception {
        Member member = new Member();
        member.setMemberId(2);
        member.setMemberName("Jane Doe");

        when(LibUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeUpdate(anyString())).thenReturn(0);

        addMemberMenu.addMember(member);

        verify(mockStatement).executeUpdate("insert into members values (2,'Jane Doe',sysdate)");
        verify(mockConnection).rollback();
        verify(mockConnection).close();
    }
}