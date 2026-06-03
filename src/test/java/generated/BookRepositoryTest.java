package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    public void testSearchByTitle() {
        // Test searching by title keyword
        bookRepository.searchByTitle("Java");
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByTitle("Unknown");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test searching by ISBN number
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByISBN(999999); // Non-existent ISBN
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test searching by genre
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertEquals(2, bookRepository.booksFound);

        assertFalse(bookRepository.searchByGenre("Unknown"));
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Test withdrawing a book
        assertTrue(bookRepository.getBook(253910));
        assertFalse(bookRepository.getBook(999999)); // Non-existent ISBN
    }

    @Test
    public void testSubmitBook() {
        // Test submitting a book
        // First, check out the book to make it available for submission
        assertTrue(bookRepository.getBook(253910));
        assertTrue(bookRepository.submitBook(253910));

        // Trying to submit a non-checked-out book
        assertFalse(bookRepository.submitBook(391520));
    }

    @Test
    public void testBookStatus() {
        // Test showing status of a book
        bookRepository.bookStatus(253910);
        // This method prints details, so we can't assert anything directly here
        // We would need to mock the System.out or check logs for detailed assertions
    }
}