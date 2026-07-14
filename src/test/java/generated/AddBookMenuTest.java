package generated;

import projectTestModify.libraryManagement.AddBookMenu; // Import the source class
import projectTestModify.libraryManagement.Book; // Assuming Book is a separate class in the libraryManagement package
import java.io.ByteArrayInputStream;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AddBookMenuTest {
    @Test
    public void testAddBookMenu() {
        String input = "1234567890\nTest Book\nTest Description\nTest Author\nTest Subject\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        AddBookMenu addBookMenu = new AddBookMenu();
        try (MockedStatic<AddBookMenu> utilities = Mockito.mockStatic(AddBookMenu.class)) {
            // Mock the behavior of LibUtil.getConnection and addBook methods
            Connection mockConn = mock(Connection.class);
            Statement mockStmt = mock(Statement.class);
            when(LibUtil.getConnection()).thenReturn(mockConn);
            when(mockConn.createStatement()).thenReturn(mockStmt);
            when(mockStmt.executeUpdate(anyString())).thenReturn(1); // Assuming the insertion is successful

            addBookMenu.addBookMenu();

            verify(mockStmt).executeUpdate("insert into books values ('1234567890','Test Book','Test Description'," +
                    "'Test Author','Test Subject',5)");
        } catch (SQLException e) {
            fail("Unexpected SQLException: " + e.getMessage());
        }
    }
}