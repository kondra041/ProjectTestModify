package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void searchByTitleTest() {
        String title = "Pride";
        bookRepository.searchByTitle(title);

        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByISBNTest() {
        int isbn = 253910;
        bookRepository.searchByISBN(isbn);

        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void searchByGenreTest() {
        String genre = "Motivational";
        boolean result = bookRepository.searchByGenre(genre);

        assertTrue(result);
    }

    @Test
    public void getBookTest() {
        int isbn = 253910;
        boolean result = bookRepository.getBook(isbn);

        assertTrue(result);
    }

    @Test
    public void submitBookTest() {
        int isbn = 253910;
        boolean result = bookRepository.submitBook(isbn);

        assertTrue(result);
    }
}