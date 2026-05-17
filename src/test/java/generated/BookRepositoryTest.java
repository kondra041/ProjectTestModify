package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

class BookRepositoryTest {

    @Mock
    private ArrayList<Book> mockBooks;

    @InjectMocks
    private BookRepository bookRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchByISBN_BookExists() {
        // Arrange
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        doNothing().when(mockBook).setCheckedOut(anyInt());
        when(mockBooks.contains(mockBook)).thenReturn(true);

        // Act
        bookRepo.searchByISBN(253910);

        // Assert
        verify(mockBook, times(1)).getIsbn();
    }

    @Test
    void testSearchByISBN_NoBookFound() {
        // Arrange
        when(mockBooks.contains(any(Book.class))).thenReturn(false);

        // Act
        bookRepo.searchByISBN(999999);

        // Assert
        System.out.printf("\n0 Book%s Found.\n", "");
    }

    @Test
    void testGetBook_Success() {
        // Arrange
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getQuantity()).thenReturn(10);
        when(mockBook.getCheckedOut()).thenReturn(7);
        
        // Act
        boolean result = bookRepo.getBook(253910);

        // Assert
        assertTrue(result);
    }

    @Test
    void testGetBook_Failure_AlreadyBorrowed() {
        // Arrange
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getQuantity()).thenReturn(10);
        when(mockBook.getCheckedOut()).thenReturn(10);

        // Act
        boolean result = bookRepo.getBook(253910);

        // Assert
        assertFalse(result);
    }

    @Test
    void testSubmitBook_Success() {
        // Arrange
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getCheckedOut()).thenReturn(7);
        
        doNothing().when(mockBook).setCheckedOut(anyInt());

        // Act
        boolean result = bookRepo.submitBook(253910);

        // Assert
        assertTrue(result);
    }

    @Test
    void testSubmitBook_Failure() {
        // Arrange
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(999999);
        when(mockBook.getCheckedOut()).thenReturn(0);

        doNothing().when(mockBook).setCheckedOut(anyInt());

        // Act
        boolean result = bookRepo.submitBook(999999);

        // Assert
        assertFalse(result);
    }
}