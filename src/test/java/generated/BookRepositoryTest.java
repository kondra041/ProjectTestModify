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
        bookRepository.searchByISBN(391520);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNNotFound() {
        bookRepository.searchByISBN(999999);
        assertEquals(0, bookRepository.booksFound);
    }
}