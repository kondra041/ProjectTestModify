package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.Statement;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.sql.SQLException;

public class AddMemberMenuTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private InputStream inContent = new ByteArrayInputStream("1\nJohn Doe".getBytes());

    @BeforeEach
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
    }

    @Test
    public void testAddMemberMenu() throws SQLException, NumberFormatException {
        AddMemberMenu.addMemberMenu();
        String expectedOutput = "Reached the add member menu\nEnter the member id \nEnter the member name\nReached inside add member for member 1\nAdded Member successfully\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testAddMember() throws SQLException {
        Member m = new Member();
        m.setMemberId(1);
        m.setMemberName("John Doe");

        Connection connMock = mock(Connection.class);
        Statement stmtMock = mock(Statement.class);
        when(LibUtil.getConnection()).thenReturn(connMock);
        when(connMock.createStatement()).thenReturn(stmtMock);
        when(stmtMock.executeUpdate(anyString())).thenReturn(1);

        AddMemberMenu.addMember(m);
        String expectedOutput = "Reached inside add member for member 1\nAdded Member successfully\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}