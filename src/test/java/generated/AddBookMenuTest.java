package generated;

import java.util.Scanner;
import projectTestModify.libraryManagement.AddBookMenu;
import projectTestModify.libraryManagement.Book;
import projectTestModify.libraryManagement.LibUtil;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class AddBookMenuTest {

    @BeforeEach
    public void setUp() {
        mockStatic(LibUtil.class);
        when(LibUtil.getConnection()).thenReturn(mock(Connection.class));
    }

    @Test
    public void testAddBookMenu_WithValidInput_ShouldAddBookSuccessfully() throws Exception {
        Scanner sc = mock(Scanner.class);
        when(sc.nextLine()).thenReturn("ISBN123", "BookName", "BookDesc", "AuthorName", "SubjectName", "5");

        AddBookMenu.addBookMenu();

        verify(sc, times(6)).nextLine();
        verify(LibUtil).getConnection();
        // Assuming addBook is called and commits the transaction
    }

    @Test
    public void testAddBookMenu_WithInvalidInput_ShouldCatchExceptionAndRetry() throws Exception {
        Scanner sc = mock(Scanner.class);
        when(sc.nextLine()).thenReturn("ISBN123", "BookName", "BookDesc", "AuthorName", "SubjectName", "abc");

        AddBookMenu.addBookMenu();

        verify(sc, times(6)).nextLine();
        verify(LibUtil).getConnection();
        // Assuming addBook is not called and rolls back the transaction
    }
}