import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @InjectMocks
    private BookRepository bookRepository;

    @Mock
    private ArrayList<Book> mockBooks;

    @BeforeEach
    void setUp() {
        // Initialize mock books as needed for tests
    }

    @Test
    void testSearchISBN_BookExists() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 5);
        when(mockBooks.stream()).anyMatch(book -> book.getIsbn() == isbn).thenReturn(true);

        int result = bookRepository.searchISBN(isbn);

        assertEquals(1, result);
    }

    @Test
    void testSearchISBN_BookDoesNotExist() {
        int isbn = 123456;
        when(mockBooks.stream()).anyMatch(book -> book.getIsbn() == isbn).thenReturn(false);

        int result = bookRepository.searchISBN(isbn);

        assertEquals(0, result);
    }

    @Test
    void testGetBook_SuccessfulCheckout() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 5);
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        boolean result = bookRepository.getBook(isbn);

        assertTrue(result);
    }

    @Test
    void testGetBook_InsufficientStock() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 0, 5); // No stock
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        boolean result = bookRepository.getBook(isbn);

        assertFalse(result);
    }

    @Test
    void testSubmitBook_SuccessfulReturn() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 5); // Checked out: 5
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        boolean result = bookRepository.submitBook(isbn);

        assertTrue(result);
    }

    @Test
    void testSubmitBook_ZeroCheckedOut() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 0); // Not checked out
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        boolean result = bookRepository.submitBook(isbn);

        assertFalse(result);
    }

    @Test
    void testSearchByTitle_FoundMultipleMatches() {
        String titleKeyword = "Programming";
        // Assume mockBooks have books matching the keyword
        when(mockBooks.stream()).filter(book -> 
            book.getTitle().toLowerCase().contains(titleKeyword.toLowerCase())).count().thenReturn(2);

        bookRepository.searchByTitle(titleKeyword);
        
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    void testSearchByISBN_Success() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 5);
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        bookRepository.searchByISBN(isbn);

        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    void testSearchByGenre_ReturnsTrueWhenMatchExists() {
        String genre = "Educational";
        // Assume mockBooks have at least one book in this genre
        when(mockBooks.stream()).anyMatch(book -> 
            book.getGenre().toLowerCase().equals(genre.toLowerCase())).thenReturn(true);

        boolean result = bookRepository.searchByGenre(genre);

        assertTrue(result);
    }

    @Test
    void testSearchByGenre_ReturnsFalseWhenNoMatches() {
        String genre = "Fiction";
        when(mockBooks.stream()).anyMatch(book -> 
            book.getGenre().toLowerCase().equals(genre.toLowerCase())).thenReturn(false);

        boolean result = bookRepository.searchByGenre(genre);

        assertFalse(result);
    }

    @Test
    void testBookStatus_DisplayDetails() {
        int isbn = 123456;
        Book mockBook = new Book(isbn, "Test Title", "Test Author", "Test Genre", 10, 5);
        when(mockBooks.contains(argThat(book -> book.getIsbn() == isbn))).thenReturn(true);

        bookRepository.bookStatus(isbn);
        
        // Verify that bookDetails was called
        verify(mockBook).getTitle();
        verify(mockBook).getAuthor();
        verify(mockBook).getGenre();
        verify(mockBook).getIsbn();
        verify(mockBook).getQuantity();
        verify(mockBook).getCheckedOut();
    }
}