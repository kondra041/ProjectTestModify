package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testGetBook_WithValidISBN_ShouldReturnTrueAndIncrementCheckedOut() {
        int isbn = 253910;
        assertTrue(bookRepository.getBook(isbn));
        assertEquals(1, bookRepository.searchISBN(isbn), "Book should be checked out");
    }

    @Test
    public void testGetBook_WithInvalidISBN_ShouldReturnFalse() {
        int isbn = 999999;
        assertFalse(bookRepository.getBook(isbn));
        assertEquals(0, bookRepository.searchISBN(isbn), "No book should be checked out");
    }
}