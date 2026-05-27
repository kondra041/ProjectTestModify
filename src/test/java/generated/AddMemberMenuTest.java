package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.Statement;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

public class AddMemberMenuTest {
    @org.junit.jupiter.api.Test
    public void testAddMember() throws Exception {
        Member m = mock(Member.class);
        when(m.getMemberId()).thenReturn(123);
        when(m.getMemberName()).thenReturn("John Doe");

        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        when(LibUtil.getConnection()).thenReturn(conn);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate(anyString())).thenReturn(1);

        AddMemberMenu.addMember(m);

        verify(stmt).executeUpdate("insert into members values (123,'John Doe',sysdate)");
        verify(conn).commit();
    }
}