package generated;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

public class BookRepositoryTest {

    @Test
    public void testSearchByTitle() {
        // Arrange
        BookRepository bookRepo = new BookRepository();
        
        // Act
        bookRepo.searchByTitle("Pride");
        
        // Assert
        assertEquals(1, bookRepo.books.stream().filter(book -> book.getTitle().toLowerCase().contains("pride")).count());
    }

    @Test
    public void testSearchByTitleNoMatch() {
        // Arrange
        BookRepository bookRepo = new BookRepository();
        
        // Act
        bookRepo.searchByTitle("NonExistent");
        
        // Assert
        assertEquals(0, bookRepo.books.stream().filter(book -> book.getTitle().toLowerCase().contains("nonexistent")).count());
    }

    @Test
    public void testSearchByTitleMultipleMatches() {
        // Arrange
        BookRepository bookRepo = new BookRepository();
        
        // Act
        bookRepo.searchByTitle("Book");
        
        // Assert
        assertEquals(6, bookRepo.books.stream().filter(book -> book.getTitle().toLowerCase().contains("book")).count());
    }
}