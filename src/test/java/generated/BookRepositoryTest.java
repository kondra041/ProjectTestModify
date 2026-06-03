package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import <PROJECT_PACKAGE>.Book;
import <PROJECT_PACKAGE>.BookRepository;

public class BookRepositoryTest {

    @Test
    public void testSearchByTitle() {
        BookRepository bookRepo = new BookRepository();
        bookRepo.searchByTitle("C");
        assertEquals(2, bookRepo.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        BookRepository bookRepo = new BookRepository();
        bookRepo.searchByISBN(391520);
        assertEquals(1, bookRepo.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(2, bookRepo.booksFound);
    }

    @Test
    public void testGetBook() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.getBook(253910);
        assertTrue(result);
    }

    @Test
    public void testSubmitBook() {
        BookRepository bookRepo = new BookRepository();
        boolean result = bookRepo.submitBook(253910);
        assertTrue(result);
    }

    @Test
    public void testBookStatus() {
        BookRepository bookRepo = new BookRepository();
        bookRepo.bookStatus(253910);
    }
}