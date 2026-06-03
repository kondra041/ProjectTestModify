import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    @Mock
    private ArrayList<Book> mockBooks;

    @Spy
    private BookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
    }

    @Test
    void searchByTitle_BookExists() {
        String title = "Pride and Prejudice";
        when(repository.searchByTitle(title)).thenCallRealMethod();
        
        repository.searchByTitle(title);
        
        verify(mockBooks).add(any(Book.class));
        assertEquals(1, repository.booksFound);
    }

    @Test
    void searchByISBN_ExistingISBN() {
        int isbn = 253910;
        when(repository.searchByISBN(isbn)).thenCallRealMethod();
        
        repository.searchByISBN(isbn);
        
        verify(mockBooks).add(any(Book.class));
        assertEquals(1, repository.booksFound);
    }

    @Test
    void searchByGenre_ValidGenre() {
        String genre = "Educational";
        when(repository.searchByGenre(genre)).thenCallRealMethod();
        boolean result = repository.searchByGenre(genre);
        
        assertTrue(result);
        assertEquals(2, repository.booksFound);
    }

    @Test
    void getBook_AvailableBook() {
        int isbn = 253910;
        boolean result = repository.getBook(isbn);
        
        assertTrue(result);
        verify(mockBooks).add(any(Book.class));
    }

    @Test
    void submitBook_SubmitsSuccessfully() {
        int isbn = 253910;
        boolean result = repository.submitBook(isbn);
        
        assertTrue(result);
        verify(mockBooks).add(any(Book.class));
    }

    @Test
    void bookStatus_ShowsCorrectDetails() {
        int isbn = 253910;
        repository.bookStatus(isbn);
        
        verify(mockBooks).add(any(Book.class));
    }
}