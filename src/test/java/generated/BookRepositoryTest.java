package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFound() {
        int isbnToFind = 253910;
        bookRepository.searchByISBN(isbnToFind);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNNotFound() {
        int isbnToFind = 987654;
        bookRepository.searchByISBN(isbnToFind);
        assertEquals(0, bookRepository.booksFound);
    }
}