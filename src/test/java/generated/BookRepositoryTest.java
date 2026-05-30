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
    public void testSearchByISBNFound() {
        int isbnToFind = 253910;
        bookRepository.searchByISBN(isbnToFind);
        assertTrue(bookRepository.booksFound > 0);
    }

    @Test
    public void testSearchByISBNNotFound() {
        int isbnToFind = 999999; // Non-existent ISBN
        bookRepository.searchByISBN(isbnToFind);
        assertEquals(0, bookRepository.booksFound);
    }
}