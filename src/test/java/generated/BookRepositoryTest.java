package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

    @InjectMocks
    private BookRepository bookRepository;

    @Mock
    private ArrayList<Book> books = new ArrayList<>();

    @Test
    public void searchByISBN_Test() {
        // Arrange
        when(books.stream().filter(book -> book.getIsbn() == 391520).findFirst()).thenReturn(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        when(books.size()).thenReturn(1);

        // Act
        bookRepository.searchByISBN(391520);

        // Assert
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByTitle_Test() {
        // Arrange
        when(books.stream().filter(book -> book.getTitle().toLowerCase().contains("programming")).findFirst()).thenReturn(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        when(books.size()).thenReturn(1);

        // Act
        bookRepository.searchByTitle("programming");

        // Assert
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByGenre_Test() {
        // Arrange
        when(books.stream().filter(book -> book.getGenre().toLowerCase().equals("educational")).findFirst()).thenReturn(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        when(books.size()).thenReturn(1);

        // Act
        boolean result = bookRepository.searchByGenre("Educational");

        // Assert
        assertTrue(result);
    }

    @Test
    public void searchISBN_Test() {
        // Arrange
        Book book = new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10);
        when(books.stream().filter(book1 -> book1.getIsbn() == 391520).findFirst()).thenReturn(book);

        // Act
        int result = bookRepository.searchISBN(391520);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void getBook_Test() {
        // Arrange
        Book book = new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10);
        when(books.stream().filter(book1 -> book1.getIsbn() == 391520).findFirst()).thenReturn(book);

        // Act
        boolean result = bookRepository.getBook(391520);

        // Assert
        assertTrue(result);
    }

    @Test
    public void submitBook_Test() {
        // Arrange
        Book book = new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10);
        when(books.stream().filter(book1 -> book1.getIsbn() == 391520).findFirst()).thenReturn(book);

        // Act
        boolean result = bookRepository.submitBook(391520);

        // Assert
        assertTrue(result);
    }

    @Test
    public void bookStatus_Test() {
        // Arrange
        Book book = new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10);
        when(books.stream().filter(book1 -> book1.getIsbn() == 391520).findFirst()).thenReturn(book);

        // Act
        bookRepository.bookStatus(391520);

        // Assert (Nothing to assert here)
    }
}