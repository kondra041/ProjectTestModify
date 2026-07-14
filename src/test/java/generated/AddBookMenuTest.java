import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import projectTestModify.libraryManagement.Book;

public class AddBookMenuTest {
    
    @Mock
    private Scanner scanner;

    @Spy
    private Book book = new Book();

    @InjectMocks
    private AddBookMenu addBookMenu;

    @BeforeEach
    void setUp() {
        // Initialize mocks and prepare for tests
    }

    @Test
    public void testAddBookMenu_success() {
        String isbnCode = "12345";
        String bookName = "Sample Book";
        String desc = "Sample Description";
        String author = "John Doe";
        String subject = "Technology";
        String unitsAvailableStr = "10";

        when(scanner.nextLine()).thenReturn(isbnCode, bookName, desc, author, subject, unitsAvailableStr);

        AddBookMenu.addBookMenu();

        verify(book).setIsbnCode(isbnCode);
        verify(book).setBookName(bookName);
        verify(book).setBookDesc(desc);
        verify(book).setAuthorName(author);
        verify(book).setSubjectName(subject);
        verify(book).setUnitsAvailable(Integer.parseInt(unitsAvailableStr));
    }

    @Test
    public void testAddBookMenu_failure() {
        // Test case where input is invalid (e.g., non-numeric units available)
        String isbnCode = "invalid";
        when(scanner.nextLine()).thenReturn(isbnCode);

        AddBookMenu.addBookMenu();

        verify(book).setIsbnCode(isbnCode);
    }
}