package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

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

        bookRepository.searchByTitle("Java");
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByTitle("C");
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test searching by ISBN
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByISBN(935141);
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByISBN(0); // Non-existent ISBN
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test searching by genre
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertEquals(2, bookRepository.booksFound);

        assertFalse(bookRepository.searchByGenre("Science"));
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Test getting a book
        assertTrue(bookRepository.getBook(253910)); // Existing ISBN with available copies
        assertFalse(bookRepository.getBook(459901)); // Existing ISBN but no available copies

        assertFalse(bookRepository.getBook(0)); // Non-existent ISBN
    }

    @Test
    public void testSubmitBook() {
        // Test submitting a book
        assertTrue(bookRepository.submitBook(253910)); // Existing ISBN with checked out books
        assertFalse(bookRepository.submitBook(459901)); // Existing ISBN but no checked out books

        assertFalse(bookRepository.submitBook(0)); // Non-existent ISBN
    }

    @Test
    public void testSearchISBN() {
        // Test searching for ISBN number
        assertEquals(1, bookRepository.searchISBN(253910));
        assertEquals(0, bookRepository.searchISBN(0)); // Non-existent ISBN
    }
}