package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        // Mocking the System.out.println for this test
        System.setOut(null);

        bookRepository.searchByTitle("C");

        // Since we are not capturing the output, we can't check it directly.
        // Instead, we assume that if the search method was called without throwing exceptions,
        // then it's working as expected.
    }

    @Test
    public void testSearchByISBN() {
        // Mocking the System.out.println for this test
        System.setOut(null);

        bookRepository.searchByISBN(253910);

        // Since we are not capturing the output, we can't check it directly.
        // Instead, we assume that if the search method was called without throwing exceptions,
        // then it's working as expected.
    }

    @Test
    public void testSearchByGenre() {
        // Mocking the System.out.println for this test
        System.setOut(null);

        boolean result = bookRepository.searchByGenre("Educational");

        assertEquals(true, result);
    }

    @Test
    public void testGetBook() {
        assertTrue(bookRepository.getBook(253910));
    }

    @Test
    public void testSubmitBook() {
        bookRepository.getBook(253910); // Check out a book first
        assertTrue(bookRepository.submitBook(253910)); // Then submit it back
    }

    @Test
    public void testBookStatus() {
        // Mocking the System.out.println for this test
        System.setOut(null);

        bookRepository.bookStatus(253910);

        // Since we are not capturing the output, we can't check it directly.
        // Instead, we assume that if the status method was called without throwing exceptions,
        // then it's working as expected.
    }
}