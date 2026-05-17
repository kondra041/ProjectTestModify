import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository;
    private ArrayList<Book> books;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
        books = new ArrayList<>();
        books.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));
        // Add other books as necessary for testing
    }

    @Test
    public void testSearchByISBN() {
        int isbn = 253910; // Replace with an existing ISBN for testing
        bookRepository.searchByISBN(isbn);
        assertEquals(1, booksFound, "Incorrect number of books found");
    }

    @Test
    public void testSearchByNonExistentISBN() {
        int isbn = 999999; // Replace with a non-existent ISBN for testing
        bookRepository.searchByISBN(isbn);
        assertEquals(0, booksFound, "Incorrect number of books found");
    }

    @Test
    public void testGetBook() {
        int isbn = 253910; // Replace with an existing ISBN for testing
        assertTrue(bookRepository.getBook(isbn), "Unable to get book");
    }

    @Test
    public void testGetNonExistentBook() {
        int isbn = 999999; // Replace with a non-existent ISBN for testing
        assertFalse(bookRepository.getBook(isbn), "Able to get non-existent book");
    }

    @Test
    public void testSubmitBook() {
        int isbn = 253910; // Replace with an existing ISBN for testing
        assertTrue(bookRepository.submitBook(isbn), "Unable to submit book");
    }

    @Test
    public void testSubmitNonExistentBook() {
        int isbn = 999999; // Replace with a non-existent ISBN for testing
        assertFalse(bookRepository.submitBook(isbn), "Able to submit non-existent book");
    }
}