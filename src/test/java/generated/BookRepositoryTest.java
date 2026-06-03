package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByGenreFoundBooks() {
        boolean result = bookRepository.searchByGenre("educational");
        assertTrue(result);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenreNoBooksFound() {
        boolean result = bookRepository.searchByGenre("fiction");
        assertFalse(result);
        assertEquals(0, bookRepository.booksFound);
    }
}