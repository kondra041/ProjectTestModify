package generated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchISBNFound() {
        int isbnToFind = 253910;
        assertEquals(1, bookRepository.searchISBN(isbnToFind));
    }

    @Test
    public void testSearchISBNNotFound() {
        int isbnToFind = 999999;
        assertEquals(0, bookRepository.searchISBN(isbnToFind));
    }
}