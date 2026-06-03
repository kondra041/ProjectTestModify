package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitleFoundBooks() {
        bookRepository.searchByTitle("java");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitleNoBooksFound() {
        bookRepository.searchByTitle("nonexistent");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNFoundBook() {
        boolean result = bookRepository.getBook(935141);
        assertTrue(result);
        assertEquals(8, bookRepository.searchISBN(935141));
    }

    @Test
    public void testSearchByISBNNoBooksFound() {
        boolean result = bookRepository.getBook(999999);
        assertFalse(result);
        assertEquals(0, bookRepository.searchISBN(999999));
    }
}