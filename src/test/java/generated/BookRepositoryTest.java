package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testGetBookSuccess() {
        boolean success = bookRepository.getBook(253910);
        assertTrue(success);
    }

    @Test
    public void testGetBookFailure() {
        boolean failure = bookRepository.getBook(999999); // ISBN not present
        assertFalse(failure);
    }

    @Test
    public void testSubmitBookSuccess() {
        // First, check out the book to make it available for submission
        bookRepository.getBook(253910);
        boolean success = bookRepository.submitBook(253910);
        assertTrue(success);
    }

    @Test
    public void testSubmitBookFailure() {
        boolean failure = bookRepository.submitBook(999999); // ISBN not present
        assertFalse(failure);
    }

    @Test
    public void testBookStatus() {
        bookRepository.bookStatus(253910);
        // This method only prints, so no assertions here
    }
}