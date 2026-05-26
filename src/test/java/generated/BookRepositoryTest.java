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
        int isbnToFind = 253910;
        bookRepository.searchByISBN(isbnToFind);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN_NotFound() {
        int isbnToFind = 999999;
        bookRepository.searchByISBN(isbnToFind);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitle_Found() {
        String titleKeyword = "pride";
        bookRepository.searchByTitle(titleKeyword);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitle_NotFound() {
        String titleKeyword = "xyz";
        bookRepository.searchByTitle(titleKeyword);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre_Found() {
        String genreToFind = "educational";
        boolean found = bookRepository.searchByGenre(genreToFind);
        assertTrue(found);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre_NotFound() {
        String genreToFind = "xyz";
        boolean found = bookRepository.searchByGenre(genreToFind);
        assertFalse(found);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook_Success() {
        int isbnToGet = 253910;
        boolean success = bookRepository.getBook(isbnToGet);
        assertTrue(success);
    }

    @Test
    public void testGetBook_Failure() {
        int isbnToGet = 999999;
        boolean success = bookRepository.getBook(isbnToGet);
        assertFalse(success);
    }

    @Test
    public void testSubmitBook_Success() {
        int isbnToSubmit = 253910;
        bookRepository.getBook(isbnToSubmit); // Check out the book first
        boolean success = bookRepository.submitBook(isbnToSubmit);
        assertTrue(success);
    }

    @Test
    public void testSubmitBook_Failure() {
        int isbnToSubmit = 999999;
        boolean success = bookRepository.submitBook(isbnToSubmit);
        assertFalse(success);
    }
}