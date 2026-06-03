package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {
    private BookRepository repository;
    
    @BeforeEach
    public void setUp() {
        repository = new BookRepository();
    }
    
    // Testing searchByTitle method
    @Test
    public void testSearchByTitle_whenNoBooksFound_returnsZeroBooks() {
        String title = "Harry Potter";
        
        assertEquals(0, repository.searchByTitle(title));
    }
    
    // Testing searchByISBN method
    @Test
    public void testSearchByISBN_whenNoBookFound_returnsZeroBooks() {
        int isbn = 99999;
        
        assertEquals(0, repository.searchByISBN(isbn));
    }
    
    // Testing searchByGenre method
    @Test
    public void testSearchByGenre_whenNoBooksFound_returnsFalse() {
        String genre = "Fantasy";
        
        assertEquals(false, repository.searchByGenre(genre));
    }
    
    // Testing getBook method
    @Test
    public void testGetBook_whenBookAvailable_returnsTrue() {
        int isbn = 253910;
        
        assertEquals(true, repository.getBook(isbn));
    }
    
    // Testing submitBook method
    @Test
    public void testSubmitBook_whenBookCheckedIn_returnsTrue() {
        int isbn = 253910;
        
        assertEquals(true, repository.submitBook(isbn));
    }
    
    // Testing bookStatus method
    @Test
    public void testBookStatus_whenBookExists_returnsCorrectDetails() {
        int isbn = 253910;
        
        assertEquals(true, repository.bookStatus(isbn));
    }
}