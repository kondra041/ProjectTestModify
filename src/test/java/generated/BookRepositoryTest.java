import java.util.ArrayList;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepo;

    @BeforeEach
    public void setup() {
        bookRepo = new BookRepository();
    }

    @Test
    public void testSearchByISBN_BookFound() {
        int isbn = 253910;
        bookRepo.searchByISBN(isbn);
        assertEquals(1, bookRepo.booksFound);
    }

    @Test
    public void testSearchByISBN_NoBookFound() {
        int isbn = 123456;
        bookRepo.searchByISBN(isbn);
        assertEquals(0, bookRepo.booksFound);
    }
}