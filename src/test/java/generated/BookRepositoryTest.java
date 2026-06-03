package generated;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookRepositoryTest {

    private BookRepository bookRepo;

    @BeforeEach
    public void setUp() {
        bookRepo = new BookRepository();
    }

    @Test
    public void testSearchByISBN() {
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book(253910, "Pride and Prejudice C", "Jane Austen", "Love", 10, 7));
        
        bookRepo.searchByISBN(253910);
        assertEquals(expectedBooks.size(), bookRepo.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        boolean result = bookRepo.searchByGenre("Educational");
        assertTrue(result);
    }
}