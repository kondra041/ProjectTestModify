package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

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
    public void testSearchByISBN_Found() {
        int isbnToSearch = 253910;
        bookRepository.searchByISBN(isbnToSearch);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN_NotFound() {
        int isbnToSearch = 999999;
        bookRepository.searchByISBN(isbnToSearch);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitle_Found() {
        String titleToSearch = "prejudice";
        bookRepository.searchByTitle(titleToSearch);
        assertTrue(bookRepository.booksFound > 0);
    }

    @Test
    public void testSearchByTitle_NotFound() {
        String titleToSearch = "nonexistent";
        bookRepository.searchByTitle(titleToSearch);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre_Found() {
        String genreToSearch = "Educational";
        boolean result = bookRepository.searchByGenre(genreToSearch);
        assertTrue(result && bookRepository.booksFound > 0);
    }

    @Test
    public void testSearchByGenre_NotFound() {
        String genreToSearch = "Nonexistent";
        boolean result = bookRepository.searchByGenre(genreToSearch);
        assertFalse(result);
    }

    @Test
    public void testGetBook_Success() {
        int isbnToCheckOut = 253910;
        boolean success = bookRepository.getBook(isbnToCheckOut);
        assertTrue(success);
    }

    @Test
    public void testGetBook_Failure() {
        int isbnToCheckOut = 855141; // All copies are checked out
        boolean success = bookRepository.getBook(isbnToCheckOut);
        assertFalse(success);
    }

    @Test
    public void testSubmitBook_Success() {
        int isbnToCheckIn = 253910;
        bookRepository.getBook(isbnToCheckIn); // Check out a book first
        boolean success = bookRepository.submitBook(isbnToCheckIn);
        assertTrue(success);
    }

    @Test
    public void testSubmitBook_Failure() {
        int isbnToCheckIn = 855141; // No copies are checked out
        boolean success = bookRepository.submitBook(isbnToCheckIn);
        assertFalse(success);
    }

    @Test
    public void testSearchISBN_Found() {
        int isbnToSearch = 253910;
        int result = bookRepository.searchISBN(isbnToSearch);
        assertEquals(1, result);
    }

    @Test
    public void testSearchISBN_NotFound() {
        int isbnToSearch = 999999;
        int result = bookRepository.searchISBN(isbnToSearch);
        assertEquals(0, result);
    }

    @Test
    public void testBookStatus_Found() {
        int isbnToCheck = 253910;
        bookRepository.bookStatus(isbnToCheck);
        // No assertion here as it's just printing, but we can verify output in real scenarios
    }
}