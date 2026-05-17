package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByTitle("C");
        assertEquals(2, bookRepository.booksFound);

        bookRepository.searchByTitle("Unknown");
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);

        bookRepository.searchByISBN(999999);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        assertTrue(bookRepository.searchByGenre("Educational"));
        assertEquals(3, bookRepository.booksFound);

        assertFalse(bookRepository.searchByGenre("Unknown"));
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        assertTrue(bookRepository.getBook(253910));
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == 253910)
                .findFirst()
                .orElse(null);
        assertEquals(7, book.getCheckedOut());

        assertFalse(bookRepository.getBook(999999));
    }

    @Test
    public void testSubmitBook() {
        assertTrue(bookRepository.submitBook(253910));
        Book book = bookRepository.books.stream()
                .filter(b -> b.getIsbn() == 253910)
                .findFirst()
                .orElse(null);
        assertEquals(6, book.getCheckedOut());

        assertFalse(bookRepository.submitBook(999999));
    }

    @Test
    public void testSearchISBN() {
        assertEquals(1, bookRepository.searchISBN(253910));
        assertEquals(0, bookRepository.searchISBN(999999));
    }

    @Test
    public void testBookStatus() {
        bookRepository.bookStatus(253910);
        // Assuming the output is captured or verified elsewhere
    }
}