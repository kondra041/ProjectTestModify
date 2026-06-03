package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testGetBookSuccess() {
        boolean result = bookRepository.getBook(253910);
        assertTrue(result, "Book should be successfully withdrawn");
        assertEquals(1, bookRepository.searchISBN(253910), "Quantity of book with ISBN 253910 should be decreased by 1");
    }

    @Test
    public void testGetBookFailure() {
        boolean result = bookRepository.getBook(253910);
        assertTrue(result, "First withdrawal should succeed");

        result = bookRepository.getBook(253910);
        assertFalse(result, "Second withdrawal for the same ISBN should fail due to insufficient quantity");
    }

    @Test
    public void testGetBookNonexistentISBN() {
        boolean result = bookRepository.getBook(999999);
        assertFalse(result, "Withdrawal with non-existent ISBN should fail");
    }
}