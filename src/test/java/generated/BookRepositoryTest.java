import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

class BookRepositoryTest {

    @Mock
    private ArrayList<Book> mockBooks;

    @InjectMocks
    private BookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
        doCallRealMethod().when(repository).addBook(any());
    }

    @Test
    void testSearchByISBN_BookExists() {
        when(mockBooks.stream()).willReturn(List.of(
            new Book(123, "Test", "Author", "Genre", 5, 0)
        ));
        repository.searchByISBN(123);
        verify(repository).searchByISBN(anyInt());
    }

    @Test
    void testSearchByISBN_BookNotExists() {
        when(mockBooks.stream()).willReturn(List.of(
            new Book(456, "Test", "Author", "Genre", 5, 0)
        ));
        repository.searchByISBN(123);
        verify(repository).searchByISBN(anyInt());
    }

    @Test
    void testGetBook_BookAvailable() {
        Book book = new Book(123, "Test", "Author", "Genre", 5, 0);
        when(mockBooks.contains(book)).thenReturn(true);
        boolean result = repository.getBook(123);
        assertTrue(result);
    }

    @Test
    void testGetBook_BookNotAvailable() {
        Book book = new Book(123, "Test", "Author", "Genre", 5, 0);
        when(mockBooks.contains(book)).thenReturn(true);
        boolean result = repository.getBook(456);
        assertFalse(result);
    }

    @Test
    void testSearchByGenre() {
        Book book1 = new Book(123, "Test1", "Author1", "Horror", 5, 0);
        Book book2 = new Book(456, "Test2", "Author2", "Educational", 3, 1);
        when(mockBooks.stream()).willReturn(List.of(book1, book2));
        boolean result = repository.searchByGenre("Educational");
        assertTrue(result);
    }
}