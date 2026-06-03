package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {
    @Test
    public void testSearchByTitle() {
        BookRepository bookRepo = new BookRepository();
        bookRepo.searchByTitle("Pride");
        // Assuming that the search for "Pride" in the title returns at least 1 result
        assertTrue(bookRepo.booksFound > 0);
    }

    @Test
    public void testSearchByISBN() {
        BookRepository bookRepo = new BookRepository();
        bookRepo.searchByISBN(391520);
        // Assuming that the search for ISBN number 391520 returns at least 1 result
        assertTrue(bookRepo.booksFound > 0);
    }

    @Test
    public void testSearchByGenre() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.searchByGenre("Educational");
        // Assuming that the search for "Educational" genre returns at least 1 result
        assertTrue(result);
    }

    @Test
    public void testSearchISBN() {
        BookRepository bookRepo = new BookRepository();
        int result = bookRepo.searchISBN(935141);
        // Assuming that the search for ISBN number 935141 returns a valid result (1)
        assertEquals(1, result);
    }

    @Test
    public void testGetBook() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.getBook(715332);
        // Assuming that the book with ISBN number 715332 is available for checkout
        assertTrue(result);
    }

    @Test
    public void testSubmitBook() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.submitBook(459901);
        // Assuming that the book with ISBN number 459901 can be submitted (checked-in)
        assertTrue(result);
    }
}