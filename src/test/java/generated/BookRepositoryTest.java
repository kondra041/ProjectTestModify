package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFound() {
        int isbn = 253910;
        bookRepository.searchByISBN(isbn);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNNotFound() {
        int isbn = 123456789;
        bookRepository.searchByISBN(isbn);
        assertEquals(0, bookRepository.booksFound);
    }
}