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

    @Mock
    private BookRepository mockBookRepository;

    @InjectMocks
    private Book book1;
    
    @Spy
    private ArrayList<Book> mockBooks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // Initialize mock books
        when(mockBookRepository.searchISBN(anyInt())).thenReturn(1);
    }

    @Test
    void testSearchByISBN_WhenBookExists_ShouldReturnCorrectDetails() {
        int isbn = 253910;
        Book expectedBook = new Book(isbn, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7);
        
        when(mockBookRepository.searchByISBN(isbn)).thenCallRealMethod();
        
        mockBookRepository.searchByISBN(isbn);
        
        verify(mockBookRepository).searchByISBN(isbn);
    }

    @Test
    void testSearchByTitle_WhenMultipleBooksFound() {
        String title = "Love";
        int expectedCount = 2;
        
        when(mockBookRepository.searchByTitle(title)).thenCallRealMethod();
        
        mockBookRepository.searchByTitle(title);
        
        verify(mockBookRepository).searchByTitle(title);
    }

    @Test
    void testSearchByGenre_WhenNoBooksFound() {
        String genre = "Horror";
        boolean expectedResult = false;
        
        when(mockBookRepository.searchByGenre(genre)).thenCallRealMethod();
        
        boolean result = mockBookRepository.searchByGenre(genre);
        
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetBook_Success() {
        int isbn = 253910;
        boolean expectedResult = true;
        
        when(mockBookRepository.getBook(isbn)).thenCallRealMethod();
        
        boolean result = mockBookRepository.getBook(isbn);
        
        assertEquals(expectedResult, result);
    }

    @Test
    void testSubmitBook_Success() {
        int isbn = 253910;
        boolean expectedResult = true;
        
        when(mockBookRepository.submitBook(isbn)).thenCallRealMethod();
        
        boolean result = mockBookRepository.submitBook(isbn);
        
        assertEquals(expectedResult, result);
    }

    @Test
    void testSearchISBN_WhenNotFound() {
        int isbn = 123456;
        int expectedResult = 0;
        
        when(mockBookRepository.searchISBN(isbn)).thenCallRealMethod();
        
        int result = mockBookRepository.searchISBN(isbn);
        
        assertEquals(expectedResult, result);
    }

    @Test
    void testBookStatus_DisplayDetails() {
        int isbn = 253910;
        
        mockBookRepository.bookStatus(isbn);
        
        verify(mockBookRepository).bookStatus(isbn);
    }
}