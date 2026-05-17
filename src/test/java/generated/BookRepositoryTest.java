package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

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
        bookRepository.searchByTitle("Pride and Prejudice");
        // Output should be the details of the book with title containing "Pride and Prejudice"
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        // Output should be the details of the book with ISBN 253910
    }

    @Test
    public void testSearchByGenre() {
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertFalse(bookRepository.searchByGenre("Unknown Genre"));
    }

    @Test
    public void testGetBook() {
        assertTrue(bookRepository.getBook(253910));
        assertFalse(bookRepository.getBook(999999)); // ISBN not found
    }

    @Test
    public void testSubmitBook() {
        bookRepository.getBook(253910); // Check out the book first
        assertTrue(bookRepository.submitBook(253910));
        assertFalse(bookRepository.submitBook(999999)); // ISBN not found
    }

    @Test
    public void testBookStatus() {
        bookRepository.bookStatus(253910);
        // Output should be the details of the book with ISBN 253910
    }
}