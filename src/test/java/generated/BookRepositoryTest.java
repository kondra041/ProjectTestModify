package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryTest {

    private BookRepository bookRepo;

    @BeforeEach
    public void setUp() {
        bookRepo = new BookRepository();
    }

    @Test
    public void testSearchByISBN() {
        bookRepo.searchByISBN(253910);
        assertEquals(1, bookRepo.booksFound);

        bookRepo.searchByISBN(999999); // ISBN that does not exist in the list
        assertEquals(0, bookRepo.booksFound);
    }

    @Test
    public void testSearchByTitle() {
        bookRepo.searchByTitle("Pride and Prejudice");
        assertEquals(1, bookRepo.booksFound);

        bookRepo.searchByTitle("Programming");
        assertEquals(2, bookRepo.booksFound); // Should find "Programming in ANSI C" and "Java: The Complete Reference"

        bookRepo.searchByTitle("nonexistent"); // Search for a non-existent title
        assertEquals(0, bookRepo.booksFound);
    }

    @Test
    public void testSearchByGenre() {
        assertTrue(bookRepo.searchByGenre("Educational")); // Should find at least one "Educational" genre

        assertFalse(bookRepo.searchByGenre("Horror"));
        assertFalse(bookRepo.searchByGenre("nonexistent")); // Search for a non-existent genre
    }

    @Test
    public void testGetBook() {
        assertTrue(bookRepo.getBook(253910));
        assertEquals(7, bookRepo.books.get(0).getCheckedOut());

        assertFalse(bookRepo.getBook(999999)); // ISBN that does not exist in the list

        assertFalse(bookRepo.getBook(391520)); // Book with quantity already 0
    }

    @Test
    public void testSubmitBook() {
        assertTrue(bookRepo.submitBook(253910));
        assertEquals(6, bookRepo.books.get(0).getCheckedOut());

        assertFalse(bookRepo.submitBook(999999)); // ISBN that does not exist in the list

        assertFalse(bookRepo.submitBook(715332)); // Book with quantity already 0
    }

    @Test
    public void testBookStatus() {
        bookRepo.bookStatus(253910);
        assertEquals("Pride and Prejudice C", bookRepo.books.get(0).getTitle());
    }
}