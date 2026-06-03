package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        when(bookRepository.getBooks()).thenReturn(new ArrayList<>());
    }

    @Test
    void testSearchByTitle() {
        bookRepository.searchByTitle("Love");
        verify(bookRepository, times(1)).bookDetails(any(Book.class));
    }

    @Test
    void testSearchByISBN() {
        bookRepository.searchByISBN(391520);
        verify(bookRepository, times(1)).bookDetails(any(Book.class));
    }

    @Test
    void testSearchByGenre() {
        boolean result = bookRepository.searchByGenre("Educational");
        assertTrue(result);
    }

    @Test
    void testGetBook() {
        boolean result = bookRepository.getBook(391520);
        assertTrue(result);
    }

    @Test
    void testSubmitBook() {
        boolean result = bookRepository.submitBook(391520);
        assertTrue(result);
    }
}