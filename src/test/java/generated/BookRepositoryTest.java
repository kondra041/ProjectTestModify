package generated;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testGetBook_WithExistingISBN_ShouldReturnTrueAndUpdateCheckedOutCount() {
        int isbn = 253910;
        boolean result = bookRepository.getBook(isbn);
        assertTrue(result);
        assertEquals(1, bookRepository.searchISBN(isbn));
    }

    @Test
    public void testGetBook_WithNonExistingISBN_ShouldReturnFalse() {
        int isbn = 999999; // Non-existing ISBN
        boolean result = bookRepository.getBook(isbn);
        assertFalse(result);
        assertEquals(0, bookRepository.searchISBN(isbn));
    }

    @Test
    public void testGetBook_WithZeroAvailableQuantity_ShouldReturnFalse() {
        int isbn = 459901; // Book with 0 available quantity
        boolean result = bookRepository.getBook(isbn);
        assertFalse(result);
        assertEquals(0, bookRepository.searchISBN(isbn));
    }
}