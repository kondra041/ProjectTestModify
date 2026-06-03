package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByGenre_Found() {
        boolean result = bookRepository.searchByGenre("Love");
        assertTrue(result, "Expected at least one book to be found with genre 'Love'");
        assertEquals(2, bookRepository.booksFound, "Expected 2 books to be found with genre 'Love'");
    }

    @Test
    public void testSearchByGenre_NotFound() {
        boolean result = bookRepository.searchByGenre("Science");
        assertFalse(result, "No books should be found with genre 'Science'");
        assertEquals(0, bookRepository.booksFound, "Expected 0 books to be found with genre 'Science'");
    }
}