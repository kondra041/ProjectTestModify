package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

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
        String titleKeyword = "Java";
        bookRepository.searchByTitle(titleKeyword);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitle_NotFound() {
        String titleKeyword = "Unknown";
        bookRepository.searchByTitle(titleKeyword);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre_Found() {
        String genreToSearch = "Educational";
        boolean result = bookRepository.searchByGenre(genreToSearch);
        assertTrue(result);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre_NotFound() {
        String genreToSearch = "Unknown";
        boolean result = bookRepository.searchByGenre(genreToSearch);
        assertFalse(result);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook_Success() {
        int isbnToCheckOut = 253910;
        boolean result = bookRepository.getBook(isbnToCheckOut);
        assertTrue(result);
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == isbnToCheckOut)
                .findFirst()
                .orElse(null);
        assertNotNull(book);
        assertEquals(8, book.getQuantity() - book.getCheckedOut());
    }

    @Test
    public void testGetBook_Failure() {
        int isbnToCheckOut = 999999;
        boolean result = bookRepository.getBook(isbnToCheckOut);
        assertFalse(result);
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == isbnToCheckOut)
                .findFirst()
                .orElse(null);
        assertNull(book);
    }

    @Test
    public void testSubmitBook_Success() {
        int isbnToCheckIn = 253910;
        bookRepository.getBook(isbnToCheckIn); // Check out the book first
        boolean result = bookRepository.submitBook(isbnToCheckIn);
        assertTrue(result);
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == isbnToCheckIn)
                .findFirst()
                .orElse(null);
        assertNotNull(book);
        assertEquals(10, book.getQuantity() - book.getCheckedOut());
    }

    @Test
    public void testSubmitBook_Failure() {
        int isbnToCheckIn = 999999;
        boolean result = bookRepository.submitBook(isbnToCheckIn);
        assertFalse(result);
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == isbnToCheckIn)
                .findFirst()
                .orElse(null);
        assertNull(book);
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
}