package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import projectTestModify.libraryManagement.AddBookMenu;
import projectTestModify.libraryManagement.Book;
import projectTestModify.libraryManagement.LibUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddBookMenuTest {

    @Mock
    private Connection mockConnection;

    @Mock
    private Statement mockStatement;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBookMenu() throws SQLException {
        // Mock the LibUtil.getConnection to return our mock connection
        when(LibUtil.getConnection()).thenReturn(mockConnection);

        // Mock the executeUpdate method of Statement
        when(mockStatement.executeUpdate(anyString())).thenReturn(1);

        // Prepare a Book object with dummy data
        Book book = new Book();
        book.setIsbnCode("123456789");
        book.setBookName("Test Book");
        book.setBookDesc("This is a test book.");
        book.setAuthorName("John Doe");
        book.setSubjectName("Science");
        book.setUnitsAvailable(10);

        // Call the addBook method
        AddBookMenu.addBook(book);

        // Verify that getConnection and executeUpdate were called
        verify(LibUtil.getConnection()).thenReturn(mockConnection);
        verify(mockStatement).executeUpdate(anyString());
    }
}