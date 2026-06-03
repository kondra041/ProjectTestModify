package generated;

import java.util.ArrayList;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BookRepositoryTest {

    @Test
    void testSearchByGenre() {
        BookRepository bookRepository = new BookRepository();

        // Test case: Genre exists
        assertTrue(bookRepository.searchByGenre("Educational"), "The genre 'Educational' should be found.");

        // Test case: Case insensitive search
        assertTrue(bookRepository.searchByGenre("educational"), "The genre 'educational' (case-insensitive) should be found.");

        // Test case: Genre does not exist
        assertFalse(bookRepository.searchByGenre("Fictional"), "The genre 'Fictional' should not be found.");
    }
}