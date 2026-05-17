import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class BookRepositoryTest {
    
    @Mock
    private BookRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchByISBN_ExistingIsbn() {
        when(repo.searchByISBN(391520)).thenCallRealMethod();
        
        verify(repo).searchByISBN(anyInt());
    }

    @Test
    void testSearchByISBN_NonExistentIsbn() {
        when(repo.searchByISBN(-1)).thenCallRealMethod();

        verify(repo).searchByISBN(anyInt());
    }

    @Test
    void testSearchByTitle_ExistingTitle() {
        String title = "C";
        repo.searchByTitle(title);
        
        verify(repo).searchByTitle(title);
    }

    @Test
    void testSearchByTitle_NonExistentTitle() {
        String title = "Java";
        repo.searchByTitle(title);
        
        verify(repo).searchByTitle(title);
    }

    @Test
    void testSearchByGenre_ExistingGenre() {
        boolean result = repo.searchByGenre("Educational");
        
        assertTrue(result);
    }

    @Test
    void testSearchByGenre_NonExistentGenre() {
        boolean result = repo.searchByGenre("Horror");
        
        assertFalse(result);
    }
}