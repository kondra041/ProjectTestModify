package generated;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    @Test
    public void testAddMemberMenu() {
        // Mock dependencies
        Member member = mock(Member.class);
        Scanner scanner = mock(Scanner.class);
        Connection connection = mock(Connection.class);
        Statement statement = mock(Statement.class);

        // Set up behavior for mocks
        when(scanner.nextLine()).thenReturn("1", "John Doe");
        when(LibUtil.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(anyString())).thenReturn(1);

        // Replace the original Scanner with the mocked one
        AddMemberMenu.setScanner(scanner);

        // Call the method under test
        AddMemberMenu.addMemberMenu();

        // Verify interactions
        verify(member).setMemberId(1);
        verify(member).setMemberName("John Doe");
        verify(connection).createStatement();
        verify(statement).executeUpdate("insert into members values (1,'John Doe',sysdate)");
        verify(connection).commit();
        verify(connection).close();

        // Restore the original Scanner
        AddMemberMenu.setScanner(new Scanner(System.in));
    }

    @Test
    public void testAddMemberFailure() {
        // Mock dependencies
        Member member = mock(Member.class);
        Scanner scanner = mock(Scanner.class);
        Connection connection = mock(Connection.class);
        Statement statement = mock(Statement.class);

        // Set up behavior for mocks
        when(scanner.nextLine()).thenReturn("abc", "John Doe");
        when(LibUtil.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(statement);
        when(statement.executeUpdate(anyString())).thenThrow(new RuntimeException());

        // Replace the original Scanner with the mocked one
        AddMemberMenu.setScanner(scanner);

        // Call the method under test
        AddMemberMenu.addMemberMenu();

        // Verify interactions
        verify(member).setMemberId(0); // Assuming setMemberId sets to 0 on failure
        verify(connection, never()).commit();
        verify(connection).close();

        // Restore the original Scanner
        AddMemberMenu.setScanner(new Scanner(System.in));
    }
}