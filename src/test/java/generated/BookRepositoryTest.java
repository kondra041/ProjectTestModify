package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBN() {
        // Arrange
        int isbnToSearch = 391520;
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));

        // Act
        bookRepository.searchByISBN(isbnToSearch);

        // Assert
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByTitle() {
        // Arrange
        String titleKeyword = "Pride";
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));

        // Act
        bookRepository.searchByTitle(titleKeyword);

        // Assert
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        // Arrange
        String genreToSearch = "Educational";
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        books.add(new Book(935141, "Java: The Complete Reference", "Herbert Schildt", "Educational", 12, 9));

        // Act
        boolean result = bookRepository.searchByGenre(genreToSearch);

        // Assert
        assertTrue(result);
        assertEquals(2, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Arrange
        int isbnToCheckOut = 391520;

        // Act
        boolean result = bookRepository.getBook(isbnToCheckOut);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testSubmitBook() {
        // Arrange
        int isbnToCheckIn = 391520;

        // Act
        boolean result = bookRepository.submitBook(isbnToCheckIn);

        // Assert
        assertTrue(result);
    }
}