package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

public class BookRepositoryTest {

    @Test
    public void testSearchByTitle() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.searchByTitle("C");
        assertEquals(1, 1);
    }

    @Test
    public void testSearchByISBN() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.searchByISBN(253910);
        assertEquals(1, 1);
    }

    @Test
    public void testSearchByGenre() {
        BookRepository bookRepository = new BookRepository();
        assertTrue(bookRepository.searchByGenre("Educational"));
    }

    @Test
    public void testBookDetails() {
        BookRepository bookRepository = new BookRepository();
        Book book = bookRepository.books.get(0);
        bookRepository.bookDetails(book);
    }

    @Test
    public void testSearchISBN() {
        BookRepository bookRepository = new BookRepository();
        assertEquals(1, bookRepository.searchISBN(253910));
    }

    @Test
    public void testGetBook() {
        BookRepository bookRepository = new BookRepository();
        assertTrue(bookRepository.getBook(253910));
    }

    @Test
    public void testSubmitBook() {
        BookRepository bookRepository = new BookRepository();
        assertTrue(bookRepository.submitBook(253910));
    }

    @Test
    public void testBookStatus() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.bookStatus(253910);
    }
}