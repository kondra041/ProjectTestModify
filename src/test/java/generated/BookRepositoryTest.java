package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFound() {
        int isbn = 253910;
        bookRepository.searchByISBN(isbn);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNNotFound() {
        int isbn = 1234567890;
        bookRepository.searchByISBN(isbn);
        assertEquals(0, bookRepository.booksFound);
    }
}