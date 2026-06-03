package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BookRepositoryTest {

    private BookRepository bookRepository;
    private ArrayList<Book> books;

    @BeforeEach
    public void setUp() {
        books = new ArrayList<>();
        books.add(new Book(253910, "Pride and Prejudice", "Jane Austen", "Love", 10, 7));
        books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        // Arrange
        String title = "Pride and Prejudice";
        int expectedBooksFound = 1;

        // Act
        bookRepository.searchByTitle(title);

        // Assert
        assertEquals(expectedBooksFound, bookRepository.booksFound);
    }

    @Test
    public void testGetBook() {
        // Arrange
        int isbn = 253910;
        boolean expectedResult = true;

        // Act
        boolean result = bookRepository.getBook(isbn);

        // Assert
        assertEquals(expectedResult, result);
    }
}