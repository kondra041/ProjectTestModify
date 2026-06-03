package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private BookRepository bookRepository;
    private ArrayList<Book> books = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
        books.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));
        books.add(new Book(391520, "Programming in ANSI C", "E. Balagurusamy", "Educational", 15, 10));
        books.add(new Book(715332, "Shrimad Bhagavad Gita", "Krishna Dvaipayana", "Motivational", 20, 18));
        books.add(new Book(935141, "Java: The Complete Reference", "Herbert Schildt", "Educational", 12, 9));
        books.add(new Book(459901, "It", "Stephan King", "Horror", 7, 5));
        books.add(new Book(855141, "Disneyland", "Mickey & Minnie", "Love", 10, 3));
    }

    @Test
    public void testGetBookWithAvailableStock() {
        assertTrue(bookRepository.getBook(253910));
        assertEquals(7, books.get(0).getCheckedOut());
    }

    @Test
    public void testGetBookWithoutAvailableStock() {
        assertFalse(bookRepository.getBook(855141));
        assertEquals(3, books.get(5).getCheckedOut());
    }
}