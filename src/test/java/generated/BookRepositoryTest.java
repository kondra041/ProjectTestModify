package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFoundBook() {
        int isbnToSearch = 253910;
        bookRepository.searchByISBN(isbnToSearch);
        assertEquals(1, bookRepository.getBooksFound());
    }

    @Test
    public void testSearchByISBNNotFoundBook() {
        int isbnToSearch = 1234567890;
        bookRepository.searchByISBN(isbnToSearch);
        assertEquals(0, bookRepository.getBooksFound());
    }
}