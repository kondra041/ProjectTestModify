package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        bookRepository.searchByTitle("Pride and Prejudice");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(3, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        boolean result = bookRepository.getBook(253910);
        assertTrue(result);
    }

    @Test
    public void testSubmitBook() {
        boolean result = bookRepository.submitBook(253910);
        assertTrue(result);
    }

    @Test
    public void testSearchISBN() {
        int result = bookRepository.searchISBN(253910);
        assertEquals(1, result);
    }
}