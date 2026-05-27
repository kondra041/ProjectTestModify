package generated;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AddMemberMenuTest {

    @Test
    public void testAddMember() throws Exception {
        Member m = new Member(1, "TestMember", null);
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);

        MockedStatic<LibUtil> libUtilMock = Mockito.mockStatic(LibUtil.class);
        libUtilMock.when(LibUtil::getConnection).thenReturn(conn);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate(anyString())).thenReturn(1);

        AddMemberMenu.addMember(m);

        verify(conn, times(1)).commit();
        verify(conn, times(1)).close();
        libUtilMock.close();
    }
}