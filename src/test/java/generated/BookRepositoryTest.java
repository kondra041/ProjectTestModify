package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void searchByTitleFoundBooks() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByTitleNoBooksFound() {
        bookRepository.searchByTitle("NonExistentTitle");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void searchByISBNFoundBook() {
        boolean result = bookRepository.searchByISBN(253910);
        assertTrue(result);
    }

    @Test
    public void searchByISBNNotFoundBook() {
        boolean result = bookRepository.searchByISBN(987654);
        assertFalse(result);
    }

    @Test
    public void searchByGenreFoundBooks() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
    }

    @Test
    public void searchByGenreNoBooksFound() {
        boolean result = bookRepository.searchByGenre("NonExistentGenre");
        assertFalse(result);
    }
}