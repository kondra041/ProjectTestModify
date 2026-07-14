package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(bookRepository.searchByGenre("Educational"));
    }

    @Test
    public void testGetBookSuccess() {
        assertTrue(bookRepository.getBook(253910));
    }

    @Test
    public void testGetBookFailure() {
        assertFalse(bookRepository.getBook(999999)); // ISBN not found
    }

    @Test
    public void testSubmitBookSuccess() {
        bookRepository.getBook(253910); // Check out the book first
        assertTrue(bookRepository.submitBook(253910));
    }

    @Test
    public void testSubmitBookFailure() {
        assertFalse(bookRepository.submitBook(999999)); // ISBN not found
    }

    @Test
    public void testBookStatus() {
        bookRepository.bookStatus(253910);
        assertEquals(1, bookRepository.booksFound);
    }
}