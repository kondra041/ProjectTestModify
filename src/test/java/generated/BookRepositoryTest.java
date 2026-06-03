package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void testSearchByGenre() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertEquals(true, result);
        result = bookRepository.searchByGenre("Fantasy");
        assertEquals(false, result);
    }
}