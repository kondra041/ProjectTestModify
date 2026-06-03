package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = spy(new BookRepository());
    }

    @Test
    void testSearchByTitle() {
        when(bookRepository.searchByTitle("Love")).thenCallRealMethod();
        bookRepository.searchByTitle("Love");
        verify(bookRepository, times(1)).searchByTitle("Love");
    }

    @Test
    void testSearchByISBN() {
        when(bookRepository.searchByISBN(253910)).thenCallRealMethod();
        bookRepository.searchByISBN(253910);
        verify(bookRepository, times(1)).searchByISBN(253910);
    }

    @Test
    void testSearchByGenre() {
        when(bookRepository.searchByGenre("Love")).thenCallRealMethod();
        assertTrue(bookRepository.searchByGenre("Love"));
    }

    @Test
    void testGetBook() {
        when(bookRepository.getBook(253910)).thenCallRealMethod();
        assertTrue(bookRepository.getBook(253910));
    }

    @Test
    void testSubmitBook() {
        when(bookRepository.submitBook(253910)).thenCallRealMethod();
        assertTrue(bookRepository.submitBook(253910));
    }

    @Test
    void testBookStatus() {
        when(bookRepository.bookStatus(253910)).thenCallRealMethod();
        bookRepository.bookStatus(253910);
        verify(bookRepository, times(1)).bookStatus(253910);
    }
}