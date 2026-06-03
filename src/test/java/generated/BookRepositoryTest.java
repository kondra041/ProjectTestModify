package generated;

import java.util.ArrayList;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void searchByISBN_ReturnsOneBook_WhenOneMatchingBookExists() {
        int isbn = 391520;
        when(bookRepository.searchISBN(isbn)).thenReturn(1);
        bookRepository.searchByISBN(isbn);
        verify(bookRepository, times(1)).bookDetails(any(Book.class));
    }

    @Test
    public void searchByISBN_ReturnsNoBooks_WhenNoMatchingBookExists() {
        int isbn = 99999;
        when(bookRepository.searchISBN(isbn)).thenReturn(0);
        bookRepository.searchByISBN(isbn);
        verify(bookRepository, times(0)).bookDetails(any(Book.class));
    }

    @Test
    public void searchByTitle_ReturnsTwoBooks_WhenTwoMatchingBookTitlesExist() {
        String title = "Pride";
        when(bookRepository.searchByISBN(anyInt())).thenReturn(2);
        bookRepository.searchByTitle(title);
        verify(bookRepository, times(2)).bookDetails(any(Book.class));
    }

    @Test
    public void searchByGenre_ReturnsNoBooks_WhenNoMatchingBookGenresExist() {
        String genre = "Drama";
        when(bookRepository.searchByISBN(anyInt())).thenReturn(0);
        bookRepository.searchByGenre(genre);
        verify(bookRepository, times(0)).bookDetails(any(Book.class));
    }

    @Test
    public void getBook_ReturnsTrue_WhenBookIsAvailable() {
        int isbn = 391520;
        when(bookRepository.searchISBN(isbn)).thenReturn(1);
        assertTrue(bookRepository.getBook(isbn));
    }

    @Test
    public void getBook_ReturnsFalse_WhenBookIsNotAvailable() {
        int isbn = 391520;
        when(bookRepository.searchISBN(isbn)).thenReturn(0);
        assertFalse(bookRepository.getBook(isbn));
    }

    @Test
    public void submitBook_ReturnsTrue_WhenBookIsSubmitted() {
        int isbn = 391520;
        when(bookRepository.searchISBN(isbn)).thenReturn(1);
        assertTrue(bookRepository.submitBook(isbn));
    }

    @Test
    public void submitBook_ReturnsFalse_WhenBookIsNotAvailable() {
        int isbn = 391520;
        when(bookRepository.searchISBN(isbn)).thenReturn(0);
        assertFalse(bookRepository.submitBook(isbn));
    }
}