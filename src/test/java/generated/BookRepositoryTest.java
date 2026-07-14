package generated;

import projectTestModify.libraryApp.BookRepository; // Import the project class explicitly
import projectTestModify.libraryApp.Book; // Import the Book class explicitly as it is used in the source code

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository(); // Initialize the object before each test
    }

    @Test
    public void testSearchByTitle() {
        // Test searching for books with title "Java" (expecting 1 match)
        bookRepository.searchByTitle("Java");
        assertEquals(1, bookRepository.booksFound);

        // Test searching for books with title "C" (expecting 2 matches)
        bookRepository.searchByTitle("C");
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        // Test searching for a specific ISBN number (expecting 1 match)
        bookRepository.searchByISBN(391520);
        assertEquals(1, bookRepository.booksFound);

        // Test searching for an ISBN number that doesn't exist in the repository (expecting 0 matches)
        bookRepository.searchByISBN(123456);
        assertEquals(0, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Test searching for books with a specific genre (expecting true as there are matching books)
        assertTrue(bookRepository.searchByGenre("Educational"));

        // Test searching for a genre that doesn't exist in the repository (expecting false)
        assertFalse(bookRepository.searchByGenre("NonExistentGenre"));
    }
}