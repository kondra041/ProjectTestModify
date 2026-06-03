package generated;

import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import java.util.ArrayList;

class BookRepositoryTest {

    @Test
    void testSearchByISBN_Existing() {
        BookRepository repo = new BookRepository();
        repo.searchByISBN(391520);
        assertEquals(1, repo.booksFound);
    }

    @Test
    void testSearchByISBN_NonExistent() {
        BookRepository repo = new BookRepository();
        repo.searchByISBN(0);
        assertEquals(0, repo.booksFound);
    }

    @Test
    void testSearchByTitle_ExactMatch() {
        BookRepository repo = new BookRepository();
        repo.searchByTitle("Pride and Prejudice C");
        assertEquals(1, repo.booksFound);
    }

    @Test
    void testSearchByTitle_PartialMatch() {
        BookRepository repo = new BookRepository();
        repo.searchByTitle("C");
        assertEquals(2, repo.booksFound);
    }

    @Test
    void testSearchByTitle_NoMatch() {
        BookRepository repo = new BookRepository();
        repo.searchByTitle("xyz");
        assertEquals(0, repo.booksFound);
    }

    @Test
    void testSearchByGenre_Educational() {
        BookRepository repo = new BookRepository();
        boolean result = repo.searchByGenre("Educational");
        assertTrue(result);
        assertEquals(2, repo.booksFound);
    }

    @Test
    void testSearchByGenre_Motivational() {
        BookRepository repo = new BookRepository();
        boolean result = repo.searchByGenre("Motivational");
        assertTrue(result);
        assertEquals(1, repo.booksFound);
    }

    @Test
    void testBookStatus() {
        BookRepository repo = new BookRepository();
        repo.bookStatus(391520);
    }
}