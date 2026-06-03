package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookRepositoryGetBookTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testGetBook_SuccessfulWithdrawal() {
        assertTrue(bookRepository.getBook(253910));
        assertFalse(bookRepository.getBook(253910)); // Second withdrawal should fail due to no available copies
    }

    @Test
    void testGetBook_FailedWithdrawal() {
        // All books checked out for this ISBN
        while (bookRepository.getBook(855141)) ;
        
        assertFalse(bookRepository.getBook(855141));
    }
}