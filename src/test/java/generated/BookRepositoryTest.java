import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTests {
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testGetBookSuccess() {
        assertTrue(bookRepository.getBook(391520));
    }

    @Test
    void testGetBookFailure() {
        assertFalse(bookRepository.getBook(999999));
    }
}