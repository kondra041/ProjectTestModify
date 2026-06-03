package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testSearchByISBN_ExistingISBN_ShouldFindBook() {
        int isbn = 253910;
        bookRepository.searchByISBN(isbn);
        
        // Redirecting System.out to capture output for validation
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.lang.System.setOut(new java.io.PrintStream(outContent));

        bookRepository.searchByISBN(isbn);

        String expectedOutput = "\n1 Book Found.\n\n+> Book details: \n\n\tTitle: Pride and Prejudice C\n\tAuthor: Jane Austen\n\tGenre: Love\n\tISBN: 253910\n\tQuantity: 10\n\tChecked Out: 7\n\tAvailable: 3\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testSearchByISBN_NonExistingISBN_ShouldNotFindBook() {
        int isbn = 999999;
        bookRepository.searchByISBN(isbn);
        
        // Redirecting System.out to capture output for validation
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.lang.System.setOut(new java.io.PrintStream(outContent));

        bookRepository.searchByISBN(isbn);

        String expectedOutput = "\n0 Books Found.\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}