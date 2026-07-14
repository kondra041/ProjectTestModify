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
        // Test searching by title
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test searching by ISBN
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test searching by genre
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Test getting a book
        assertTrue(bookRepository.getBook(391520));
    }

    @Test
    public void testSubmitBook() {
        // Test submitting a book
        assertTrue(bookRepository.submitBook(391520));
    }

    @Test
    public void testSearchISBN() {
        // Test searching for ISBN
        assertEquals(1, bookRepository.searchISBN(715332));
    }

    @Test
    public void testBookStatus() {
        // Test getting book status
        bookRepository.bookStatus(935141);
    }
}