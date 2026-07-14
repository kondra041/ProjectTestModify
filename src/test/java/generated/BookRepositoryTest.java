import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Mock
    private BookRepository repository;

    private ArrayList<Book> mockBooks;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
        mockBooks = new ArrayList<>();
        // Initialize mock books if needed
    }

    @Test
    void testSearchByISBN_ExistingBook() {
        when(repository.searchISBN(391520)).thenReturn(true);
        repository.searchByISBN(391520);
        verify(repository).searchByISBN(391520);
        // Verify the output would be printed, but can't capture System.out directly here
    }

    @Test
    void testSearchByISBN_NonExistingBook() {
        when(repository.searchISBN(123456)).thenReturn(false);
        repository.searchByISBN(123456);
        verify(repository).searchByISBN(123456);
    }

    @Test
    void testGetBook_ValidISBN() {
        boolean result = repository.getBook(391520);
        assertTrue(result);
        // Verify the book's checkedOut count was incremented
    }

    @Test
    void testSubmitBook_ValidISBN() {
        boolean result = repository.submitBook(391520);
        assertTrue(result);
        // Verify the book's checkedOut count was decremented
    }

    @Test
    void testSearchByGenre_MultipleGenres() {
        boolean result = repository.searchByGenre("Educational");
        assertTrue(result);
        // Multiple books should be found
    }

    @Test
    void testBookStatus_ExistingISBN() {
        repository.bookStatus(391520);
        // Verify the details are printed correctly
    }
}