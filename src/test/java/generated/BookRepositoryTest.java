import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class BookRepositoryTest {

    @InjectMocks
    private BookRepository repository;

    @Mock
    private ArrayList<Book> mockBooks;

    @Spy
    private Book book1, book2, book3;

    @BeforeAll
    void setUp() {
        repository = new BookRepository();
        when(book1.getIsbn()).thenReturn(253910);
        when(book2.getIsbn()).thenReturn(391520);
        when(book3.getIsbn()).thenReturn(715332);
        
        ArrayList<Book> mockBooks = new ArrayList<>();
        mockBooks.add(book1);
        mockBooks.add(book2);
        mockBooks.add(book3);
        doNothing().when(mockBooks).add(any(Book.class));
    }

    @Test
    void testSearchByISBNFound() {
        when(repository.searchISBN(253910)).thenReturn(1);
        repository.searchByISBN(253910);
        verify(repository).searchByISBN(253910);
    }

    @Test
    void testSearchByISBNNotFound() {
        when(book1.getIsbn()).thenReturn(999999);
        when(book2.getIsbn()).thenReturn(999998);
        repository.searchByISBN(253910);
        verify(repository).searchByISBN(253910);
    }

    @Test
    void testSearchByTitleFound() {
        repository.searchByTitle("C");
        assertEquals(2, repository.booksFound);
    }

    @Test
    void testSearchByGenreSuccess() {
        boolean result = repository.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(2, repository.booksFound);
    }

    @Test
    void testGetBookSuccess() {
        boolean result = repository.getBook(391520);
        assertTrue(result);
    }

    @Test
    void testSubmitBookFailure() {
        boolean result = repository.submitBook(999999);
        assertFalse(result);
    }

    @Test
    void testBookStatusCheckedOut() {
        repository.bookStatus(391520);
        verify(repository).bookDetails(any(Book.class));
    }
}