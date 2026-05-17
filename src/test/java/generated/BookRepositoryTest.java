package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        // Test with a title that should match multiple books
        bookRepository.searchByTitle("e");
        assertEquals(3, bookRepository.booksFound);

        // Test with a title that should match one book
        bookRepository.searchByTitle("Pride and Prejudice");
        assertEquals(1, bookRepository.booksFound);

        // Test with a title that should not match any books
        bookRepository.searchByTitle("NonExistentTitle");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test with an ISBN that exists
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        // Test with an ISBN that does not exist
        bookRepository.searchByISBN(999999);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test with a genre that should match multiple books
        assertTrue(bookRepository.searchByGenre("Educational"));

        // Test with a genre that should not match any books
        assertFalse(bookRepository.searchByGenre("NonExistentGenre"));
    }

    @Test
    public void testGetBook() {
        // Test getting a book that is available
        assertTrue(bookRepository.getBook(253910));

        // Test getting a book that is already checked out
        for (int i = 0; i < bookRepository.books.get(0).getQuantity(); i++) {
            bookRepository.getBook(253910);
        }
        assertFalse(bookRepository.getBook(253910));
    }

    @Test
    public void testSubmitBook() {
        // Test submitting a book that was checked out
        bookRepository.getBook(253910);
        assertTrue(bookRepository.submitBook(253910));

        // Test submitting a book that was not checked out
        assertFalse(bookRepository.submitBook(253910));
    }

    @Test
    public void testBookStatus() {
        // Test getting the status of a book
        bookRepository.bookStatus(253910);
        assertEquals(7, bookRepository.books.get(0).getCheckedOut());
    }
}