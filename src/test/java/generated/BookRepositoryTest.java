import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import java.util.ArrayList;

public class BookRepositoryTest {
    private final BookRepository bookRepository = new BookRepository();

    @org.junit.jupiter.api.Test
    public void searchByISBNTest() {
        // Test searching for a valid ISBN number
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        // Test searching for an invalid ISBN number
        bookRepository.searchByISBN(000000);
        assertEquals(0, bookRepository.booksFound);
    }
}