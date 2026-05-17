package generated;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddMemberMenuTest {

    @Test
    public void testAddMember() throws SQLException {
        Member m = new Member();
        m.setMemberId(1);
        m.setMemberName("John Doe");

        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);

        MockedStatic<LibUtil> libUtilMockedStatic = mockStatic(LibUtil.class);
        libUtilMockedStatic.when(LibUtil::getConnection).thenReturn(conn);

        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate("insert into members values (" + m.getMemberId() + ",'" + m.getMemberName() + "',sysdate)")).thenReturn(1);

        AddMemberMenu.addMember(m);

        verify(conn).commit();
        verify(conn).close();

        libUtilMockedStatic.close();
    }
}