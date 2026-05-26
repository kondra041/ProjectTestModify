import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @Spy
    private BookRepository repository;

    @Mock
    private ArrayList<Book> mockBookList;

    @BeforeEach
    void setUp() {
        // Create a TestBookRepository with predefined books for testing
        repository = new BookRepository();
    }

    @Test
    void testSearchByISBN_BookExists() {
        // Given an ISBN that exists in the list
        int isbnToFind = 253910;
        
        when(repository.searchISBN(isbnToFind)).thenReturn(1);
        
        repository.searchByISBN(isbnToFind);
        
        verify(repository).searchISBN(isbnToFind);
    }

    @Test
    void testSearchByISBN_BookDoesNotExist() {
        int isbnToFind = 999999;
        
        when(repository.searchISBN(isbnToFind)).thenReturn(0);
        
        repository.searchByISBN(isbnToFind);
        
        verify(repository).searchISBN(isbnToFind);
    }

    @Test
    void testSearchByTitle_ExactMatch() {
        String title = "Pride and Prejudice C";
        
        repository.searchByTitle(title);
        
        verify(mockBookList).iterator();
    }

    @Test
    void testSearchByTitle_PartialMatch() {
        String title = "C";
        
        repository.searchByTitle(title);
        
        verify(mockBookList).iterator();
    }

    @Test
    void testSearchByGenre_ReturnTrue() {
        boolean result = repository.searchByGenre("Educational");
        
        assertTrue(result);
    }

    @Test
    void testSearchByGenre_ReturnFalse() {
        boolean result = repository.searchByGenre("Non-existent genre");
        
        assertFalse(result);
    }
}