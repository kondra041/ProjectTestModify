package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTests {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByTitle() {
        // Given
        String title = "Pride and Prejudice";

        // When
        List<Book> books = bookRepository.searchByTitle(title);

        // Then
        assertNotNull(books);
        assertEquals(1, books.size());
    }

    @Test
    public void testSearchByISBN() {
        // Given
        int isbn = 253910;

        // When
        Book book = bookRepository.searchByISBN(isbn);

        // Then
        assertNotNull(book);
        assertEquals("Pride and Prejudice C", book.getTitle());
    }

    @Test
    public void testSearchByGenre() {
        // Given
        String genre = "Educational";

        // When
        List<Book> books = bookRepository.searchByGenre(genre);

        // Then
        assertNotNull(books);
        assertEquals(2, books.size());
    }
}