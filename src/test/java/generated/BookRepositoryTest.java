package generated;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private final BookRepository bookRepository = new BookRepository();

    @Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        bookRepository.searchByGenre("Educational");
        assertTrue(bookRepository.booksFound > 0);
    }

    @Test
    public void testBookDetails() {
        Book book = new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        bookRepository.bookDetails(book);
    }

    @Test
    public void testSearchISBN() {
        assertEquals(1, bookRepository.searchISBN(253910));
    }

    @Test
    public void testGetBook() {
        assertTrue(bookRepository.getBook(253910));
    }

    @Test
    public void testSubmitBook() {
        assertFalse(bookRepository.submitBook(391520));
    }

    @Test
    public void testBookStatus() {
        bookRepository.bookStatus(253910);
    }
}

import projectTestModify.libraryApp.Book;