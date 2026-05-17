package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByGenreFoundBooks() {
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenreNoBooksFound() {
        assertFalse(bookRepository.searchByGenre("Fiction"));
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenreCaseInsensitive() {
        assertTrue(bookRepository.searchByGenre("loVe"));
        assertEquals(1, bookRepository.booksFound);
    }
}