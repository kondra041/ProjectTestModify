package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BookRepositoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride and Prejudice C");
        assertTrue(outContent.toString().contains("1 Book Found."));
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(391520);
        assertTrue(outContent.toString().contains("1 Book Found."));
    }

    @Test
    public void testSearchByGenre() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result && outContent.toString().contains("2 Books Found."));
    }

    @Test
    public void testGetBook() {
        boolean result = bookRepository.getBook(253910);
        assertTrue(result);
    }

    @Test
    public void testSubmitBook() {
        bookRepository.getBook(253910);
        boolean result = bookRepository.submitBook(253910);
        assertTrue(result);
    }
}