import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

class BookRepositoryTest {

    private BookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
    }

    @Test
    void searchByISBN_ExistingBook() {
        repository.searchByISBN(253910);
        // Verify correct output and booksFound value
        assertEquals(1, repository.booksFound);
    }

    @Test
    void searchByISBN_NonExisting() {
        repository.searchByISBN(-1);
        // Verify no books found
        assertEquals(0, repository.booksFound);
    }

    @Test
    void searchByTitle_ExactMatch() {
        repository.searchByTitle("Love");
        // Verify correct number of matches and output
        assertNotEquals(0, repository.booksFound);
    }

    @Test
    void searchByGenre_SpecificGenre() {
        boolean result = repository.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(2, repository.booksFound);
    }

    @Test
    void getBook_SuccessfulCheckout() {
        boolean result = repository.getBook(391520);
        assertTrue(result);
        // Verify quantity decreased by 1
    }

    @Test
    void submitBook_SuccessfulSubmit() {
        boolean result = repository.submitBook(391520);
        assertTrue(result);
        // Verify quantity increased by 1
    }

    @Test
    void bookStatus_CurrentStatus() {
        repository.bookStatus(715332);
        // Verify correct status is displayed
    }
}