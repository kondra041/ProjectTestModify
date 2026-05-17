package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void searchByTitleFoundOneBook() {
        String title = "Pride";
        bookRepository.searchByTitle(title);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByTitleFoundMultipleBooks() {
        String title = "love";
        bookRepository.searchByTitle(title);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void searchByTitleNotFoundAnyBook() {
        String title = "Unknown Title";
        bookRepository.searchByTitle(title);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void searchByISBNFoundOneBook() {
        int isbn = 253910;
        boolean result = bookRepository.searchByISBN(isbn);
        assertTrue(result);
    }

    @Test
    public void searchByISBNotFoundAnyBook() {
        int isbn = 123456;
        boolean result = bookRepository.searchByISBN(isbn);
        assertFalse(result);
    }

    @Test
    public void searchByGenreFoundOneBook() {
        String genre = "Educational";
        boolean result = bookRepository.searchByGenre(genre);
        assertTrue(result);
    }

    @Test
    public void searchByGenreNotFoundAnyBook() {
        String genre = "Unknown Genre";
        boolean result = bookRepository.searchByGenre(genre);
        assertFalse(result);
    }
}