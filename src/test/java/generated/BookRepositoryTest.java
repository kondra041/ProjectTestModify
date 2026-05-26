package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BookRepositoryTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGetBookAvailable() {
        BookRepository repository = new BookRepository();
        boolean result = repository.getBook(391520); // This book is available
        assertTrue(result);
    }

    @Test
    public void testGetBookUnavailable() {
        BookRepository repository = new BookRepository();
        for (int i = 0; i < 15; i++) { // Checking out all copies of this book
            repository.getBook(391520);
        }
        boolean result = repository.getBook(391520); // This book is unavailable now
        assertFalse(result);
    }

    @Test
    public void testSubmitBookAvailable() {
        BookRepository repository = new BookRepository();
        for (int i = 0; i < 5; i++) { // Checking out some copies of this book
            repository.getBook(459901);
        }
        boolean result = repository.submitBook(459901); // This book has been checked out, so it's available to be submitted
        assertTrue(result);
    }

    @Test
    public void testSubmitBookUnavailable() {
        BookRepository repository = new BookRepository();
        boolean result = repository.submitBook(459901); // This book hasn't been checked out yet, so it's not available to be submitted
        assertFalse(result);
    }
}