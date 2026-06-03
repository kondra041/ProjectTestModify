package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

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

        bookRepository.searchByTitle("Educational");
        assertEquals(2, bookRepository.booksFound);

        bookRepository.searchByTitle("Nonexistent");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test searching by ISBN
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByISBN(999999); // Nonexistent ISBN
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test searching by genre
        assertTrue(bookRepository.searchByGenre("Love"));
        assertEquals(2, bookRepository.booksFound);

        assertFalse(bookRepository.searchByGenre("Nonexistent"));
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Test getting a book
        assertTrue(bookRepository.getBook(253910)); // Existing ISBN with available copies

        assertFalse(bookRepository.getBook(999999)); // Nonexistent ISBN

        Book book = new Book(715332, "Shrimad Bhagavad Gita", "Krishna Dvaipayana", "Motivational", 20, 18);
        assertTrue(bookRepository.getBook(715332)); // Existing ISBN with available copies
    }

    @Test
    public void testSubmitBook() {
        // Test submitting a book
        Book book = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        assertTrue(bookRepository.submitBook(253910)); // Existing ISBN with checked out copies

        assertFalse(bookRepository.submitBook(999999)); // Nonexistent ISBN
    }

    @Test
    public void testSearchISBN() {
        // Test searching for ISBN
        assertEquals(1, bookRepository.searchISBN(253910)); // Existing ISBN

        assertEquals(0, bookRepository.searchISBN(999999)); // Nonexistent ISBN
    }
}