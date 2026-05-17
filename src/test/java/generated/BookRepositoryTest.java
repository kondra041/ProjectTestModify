package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @InjectMocks
    private BookRepository bookRepository;

    @Spy
    private ArrayList<Book> books = new ArrayList<>();

    @Test
    void testSearchByTitle() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        // Mock some books for testing
        Book mockBook1 = mock(Book.class);
        when(mockBook1.getTitle()).thenReturn("Pride and Prejudice C");
        doNothing().when(mockBook1).setCheckedOut(anyInt());
        
        Book mockBook2 = mock(Book.class);
        when(mockBook2.getTitle()).thenReturn("Programming in ANSI C");
        
        // Add mocks to the repository
        bookRepository.books.add(mockBook1);
        bookRepository.books.add(mockBook2);
        
        // Test search for "pride"
        bookRepository.searchByTitle("pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    void testSearchByISBN() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        
        // Add to repository
        bookRepository.books.add(mockBook);
        
        int result = bookRepository.searchISBN(253910);
        assertEquals(1, result);
    }

    @Test
    void testSearchByGenre() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        Book mockBook1 = mock(Book.class);
        when(mockBook1.getGenre()).thenReturn("Educational");
        
        Book mockBook2 = mock(Book.class);
        when(mockBook2.getGenre()).thenReturn("Educational");
        
        // Add to repository
        bookRepository.books.add(mockBook1);
        bookRepository.books.add(mockBook2);
        
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
    }

    @Test
    void testGetBookSuccessfullyBorrowsIt() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getQuantity()).thenReturn(10);
        when(mockBook.getCheckedOut()).thenReturn(7);
        
        // Add to repository
        bookRepository.books.add(mockBook);
        
        boolean result = bookRepository.getBook(253910);
        assertTrue(result);
    }

    @Test
    void testSubmitBookSuccessfullySubmitsIt() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getCheckedOut()).thenReturn(7);
        
        // Add to repository
        bookRepository.books.add(mockBook);
        
        boolean result = bookRepository.submitBook(253910);
        assertTrue(result);
    }

    @Test
    void testBookStatusDisplay() {
        when(bookRepository.books).thenReturn(new ArrayList<>());
        
        Book mockBook = mock(Book.class);
        when(mockBook.getIsbn()).thenReturn(253910);
        when(mockBook.getTitle()).thenReturn("Test Title");
        when(mockBook.getAuthor()).thenReturn("Test Author");
        when(mockBook.getGenre()).thenReturn("Test Genre");
        when(mockBook.getQuantity()).thenReturn(10);
        when(mockBook.getCheckedOut()).thenReturn(7);
        
        // Add to repository
        bookRepository.books.add(mockBook);
        
        bookRepository.bookStatus(253910);
    }
}