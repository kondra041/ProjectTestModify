package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookRepositoryTest {
    private BookRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new BookRepository();
    }

    @Test
    public void searchByTitle_foundBooks_returnsCorrectResults() {
        String title = "Pride and Prejudice";
        List<Book> books = repository.searchByTitle(title);

        assertEquals(1, books.size());
        Book book = books.get(0);
        assertEquals("Pride and Prejudice C", book.getTitle());
    }

    @Test
    public void searchByISBN_foundBook_returnsCorrectResults() {
        int isbn = 253910;
        Book book = repository.searchByISBN(isbn);

        assertEquals("Pride and Prejudice C", book.getTitle());
    }

    @Test
    public void searchByGenre_foundBooks_returnsCorrectResults() {
        String genre = "Love";
        List<Book> books = repository.searchByGenre(genre);

        assertEquals(2, books.size());
        Book book1 = books.get(0);
        Book book2 = books.get(1);
        assertTrue((book1.getTitle().equals("Pride and Prejudice C") && book2.getTitle().equals("Disneyland")) || (book1.getTitle().equals("Disneyland") && book2.getTitle().equals("Pride and Prejudice C")));
    }
}