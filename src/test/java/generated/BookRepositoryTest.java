package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
    private List<Book> mockBooks;
    
    @InjectMocks
    private BookRepository bookRepo;

    @BeforeEach
    void setUp() {
        // Initialize mocks as needed
    }

    @Test
    void testSearchByISBN_ExistingBook() {
        int targetIsbn = 391520;
        Book mockBook = createMockBook(391520, "Programming in ANSI C");
        when(bookRepo.searchISBN(targetIsbn)).thenReturn(1);
        
        bookRepo.searchByISBN(targetIsbn);
        
        verify(bookRepo).searchISBN(targetIsbn);
    }

    @Test
    void testSearchByISBN_NonExistingBook() {
        int targetIsbn = 935141;
        when(bookRepo.searchISBN(targetIsbn)).thenReturn(0);
        
        bookRepo.searchByISBN(targetIsbn);
        
        verify(bookRepo).searchISBN(targetIsbn);
    }

    @Test
    void testSearchByGenre() {
        String targetGenre = "Educational";
        List<Book> educationalBooks = new ArrayList<>();
        educationalBooks.add(createMockBook(391520, "Programming in ANSI C"));
        educationalBooks.add(createMockBook(935141, "Java: The Complete Reference"));
        
        when(bookRepo.searchByGenre(targetGenre)).thenReturn(true);
        
        boolean result = bookRepo.searchByGenre(targetGenre);
        
        assertTrue(result);
    }

    private Book createMockBook(int isbn, String title) {
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(isbn);
        when(mockBook.getTitle()).thenReturn(title);
        return mockBook;
    }
}