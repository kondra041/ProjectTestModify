package generated;

import org.junit.jupiter.api.*;
import projectTestModify.libraryApp.*;

public class BookRepositoryTests {

    private BookRepository bookRepo;

    @BeforeEach
    void init() {
        this.bookRepo = new BookRepository();
    }

    @Test
    void testSearchByTitle_ValidBookFound() {
        String title = "Pride and Prejudice C";
        int expectedCount = 1;

        bookRepo.searchByTitle(title);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }

    @Test
    void testSearchByTitle_InvalidBookFound() {
        String title = "The Great Gatsby";
        int expectedCount = 0;

        bookRepo.searchByTitle(title);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }

    @Test
    void testSearchByISBN_ValidBookFound() {
        int isbn = 253910;
        int expectedCount = 1;

        bookRepo.searchByISBN(isbn);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }

    @Test
    void testSearchByISBN_InvalidBookFound() {
        int isbn = 213456;
        int expectedCount = 0;

        bookRepo.searchByISBN(isbn);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }

    @Test
    void testSearchByGenre_ValidBookFound() {
        String genre = "Educational";
        int expectedCount = 1;

        bookRepo.searchByGenre(genre);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }

    @Test
    void testSearchByGenre_InvalidBookFound() {
        String genre = "Action";
        int expectedCount = 0;

        bookRepo.searchByGenre(genre);

        assertEquals(expectedCount, bookRepo.getBooks().size());
    }
}