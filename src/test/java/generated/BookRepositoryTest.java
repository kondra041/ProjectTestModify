package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {

    @Test
    void testSearchByISBN_ExistingISBN_ShouldFindBook() {
        // Arrange
        BookRepository bookRepository = new BookRepository();
        int existingIsbn = 253910;
        
        // Act
        bookRepository.searchByISBN(existingIsbn);
        
        // Assert
        // Redirect the output to capture the result for assertion
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        
        bookRepository.searchByISBN(existingIsbn);
        
        String expectedOutput = "\n1 Book Found.\n\n+> Book details: \n\n\tTitle: Pride and Prejudice C\n\tAuthor: Jane Austen\n\tGenre: Love\n\tISBN: 253910\n\tQuantity: 10\n\tChecked Out: 7\n\tAvailable: 3\n";
        assertEquals(expectedOutput, outContent.toString());
        
        // Restore the original standard output
        System.setOut(System.out);
    }

    @Test
    void testSearchByISBN_NonExistingISBN_ShouldFindNoBooks() {
        // Arrange
        BookRepository bookRepository = new BookRepository();
        int nonExistingIsbn = 999999;
        
        // Act
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        
        bookRepository.searchByISBN(nonExistingIsbn);
        
        // Assert
        String expectedOutput = "\n0 Books Found.\n";
        assertEquals(expectedOutput, outContent.toString());
        
        // Restore the original standard output
        System.setOut(System.out);
    }
}