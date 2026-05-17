package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchISBNFound() {
        int isbn = 253910;
        assertEquals(1, bookRepository.searchISBN(isbn));
    }

    @Test
    public void testSearchISBNNotFound() {
        int isbn = 999999;
        assertEquals(0, bookRepository.searchISBN(isbn));
    }
}