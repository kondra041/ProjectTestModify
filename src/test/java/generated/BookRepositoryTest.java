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
    public void testSearchByTitleFound() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.getBooksFound());
    }

    @Test
    public void testSearchByTitleNotFound() {
        bookRepository.searchByTitle("Unknown");
        assertEquals(0, bookRepository.getBooksFound());
    }
}