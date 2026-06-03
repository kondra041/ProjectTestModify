package generated;

import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    public void testSearchByISBNFound() {
        // Act
        bookRepository.searchByISBN(253910);
        
        // Assert
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBNNotFound() {
        // Act
        bookRepository.searchByISBN(999999);
        
        // Assert
        assertEquals(0, bookRepository.booksFound);
    }
}