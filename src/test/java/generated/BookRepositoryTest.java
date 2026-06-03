package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFound() {
        int isbnToSearch = 391520;
        bookRepository.searchByISBN(isbnToSearch);
        verify(bookRepository, times(1)).searchByISBN(isbnToSearch);
    }

    @Test
    public void testGetBookAvailable() {
        int isbn = 391520;
        assertTrue(bookRepository.getBook(isbn));
    }

    @Test
    public void testSubmitBook() {
        int isbn = 459901;
        assertTrue(bookRepository.submitBook(isbn));
    }
}