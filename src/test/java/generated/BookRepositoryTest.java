package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride");
        assertTrue(outContent.toString().contains("1 Book Found."));
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(391520);
        assertTrue(outContent.toString().contains("1 Book Found."));
    }

    @Test
    public void testSearchByGenre() {
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertTrue(outContent.toString().contains("2 Books Found."));
    }

    @Test
    public void testGetBookSuccessful() {
        assertTrue(bookRepository.getBook(391520));
    }

    @Test
    public void testGetBookUnsuccessful() {
        for (int i = 0; i < 15; i++) {
            bookRepository.getBook(391520); // Get all available books
        }
        assertFalse(bookRepository.getBook(391520)); // Try to get one more
    }

    @Test
    public void testSubmitBookSuccessful() {
        bookRepository.getBook(391520); // Get a book first
        assertTrue(bookRepository.submitBook(391520));
    }

    @Test
    public void testSubmitBookUnsuccessful() {
        assertFalse(bookRepository.submitBook(391520)); // Try to submit without getting
    }
}