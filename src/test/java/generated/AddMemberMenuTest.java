package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;
import projectTestModify.libraryManagement.LibUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddMember() throws SQLException {
        Member member = new Member();
        member.setMemberId(1);
        member.setMemberName("John Doe");

        when(LibUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeUpdate(anyString())).thenReturn(1);

        AddMemberMenu.addMember(member);

        verify(mockConnection).commit();
        verify(mockConnection, never()).rollback();
    }

    @Test
    public void testAddMemberFailure() throws SQLException {
        Member member = new Member();
        member.setMemberId(1);
        member.setMemberName("John Doe");

        when(LibUtil.getConnection()).thenReturn(mockConnection);
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeUpdate(anyString())).thenReturn(0);

        AddMemberMenu.addMember(member);

        verify(mockConnection).rollback();
    }
}