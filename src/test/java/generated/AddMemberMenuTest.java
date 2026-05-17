package generated;

import java.sql.Connection;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    private AddMemberMenu addMemberMenu;
    private Member memberMock;
    private Connection connectionMock;
    private Scanner scannerMock;

    @BeforeEach
    public void setUp() {
        addMemberMenu = new AddMemberMenu();
        memberMock = mock(Member.class);
        connectionMock = mock(Connection.class);
        scannerMock = mock(Scanner.class);

        // Mock LibUtil.getConnection()
        when(LibUtil.getConnection()).thenReturn(connectionMock);
    }

    @Test
    public void testAddMemberMenu_withValidInput() throws Exception {
        // Arrange
        when(scannerMock.nextLine()).thenReturn("1", "John Doe");
        when(memberMock.getMemberId()).thenReturn(1);
        when(memberMock.getMemberName()).thenReturn("John Doe");

        // Act
        addMemberMenu.addMemberMenu();

        // Assert
        verify(memberMock, times(1)).setMemberId(1);
        verify(memberMock, times(1)).setMemberName("John Doe");
        verify(connectionMock, times(1)).createStatement();
        verify(stmtMock, times(1)).executeUpdate("insert into members values (1,'John Doe',sysdate)");
        verify(connectionMock, times(1)).commit();
    }

    @Test
    public void testAddMemberMenu_withInvalidInput() throws Exception {
        // Arrange
        when(scannerMock.nextLine()).thenReturn("abc", "John Doe");

        // Act
        addMemberMenu.addMemberMenu();

        // Assert
        verify(memberMock, times(0)).setMemberId(anyInt());
        verify(memberMock, times(0)).setMemberName(anyString());
        verify(connectionMock, times(0)).createStatement();
        verify(stmtMock, times(0)).executeUpdate(anyString());
        verify(connectionMock, times(0)).commit();
    }

    @Test
    public void testAddMember_withValidInput() throws Exception {
        // Arrange
        Statement stmtMock = mock(Statement.class);
        when(LibUtil.getConnection()).thenReturn(connectionMock);
        when(connectionMock.createStatement()).thenReturn(stmtMock);
        when(memberMock.getMemberId()).thenReturn(1);
        when(memberMock.getMemberName()).thenReturn("John Doe");

        // Act
        addMemberMenu.addMember(memberMock);

        // Assert
        verify(stmtMock, times(1)).executeUpdate("insert into members values (1,'John Doe',sysdate)");
        verify(connectionMock, times(1)).commit();
    }

    @Test
    public void testAddMember_withException() throws Exception {
        // Arrange
        Statement stmtMock = mock(Statement.class);
        when(LibUtil.getConnection()).thenReturn(connectionMock);
        when(connectionMock.createStatement()).thenReturn(stmtMock);
        when(memberMock.getMemberId()).thenReturn(1);
        when(memberMock.getMemberName()).thenReturn("John Doe");
        doThrow(new Exception("Database error")).when(stmtMock).executeUpdate(anyString());

        // Act
        addMemberMenu.addMember(memberMock);

        // Assert
        verify(stmtMock, times(1)).executeUpdate("insert into members values (1,'John Doe',sysdate)");
        verify(connectionMock, times(1)).rollback();
    }
}