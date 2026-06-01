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
    public void testSearchByGenre_FoundBooks() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
    }

    @Test
    public void testSearchByGenre_NoBooksFound() {
        boolean result = bookRepository.searchByGenre("Comedy");
        assertFalse(result);
    }
}