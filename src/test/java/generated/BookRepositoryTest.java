package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        bookRepository = new BookRepository();
    }

    @org.junit.jupiter.api.Test
    public void testSearchByTitle() {
        bookRepository.searchByTitle("Pride");
        assertEquals(1, bookRepository.booksFound);
    }

    @org.junit.jupiter.api.Test
    public void testSearchByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @org.junit.jupiter.api.Test
    public void testSearchByGenre() {
        assertTrue(bookRepository.searchByGenre("Motivational"));
        assertEquals(1, bookRepository.booksFound);
    }
}