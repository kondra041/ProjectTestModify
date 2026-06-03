package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    BookRepository bookRepository = new BookRepository();

    @Test
    public void shouldSearchBookByISBN() {
        bookRepository.searchByISBN(253910);
        assertEquals(1, bookRepository.booksFound);
    }

    @Test
    public void shouldNotSearchBookByISBN() {
        bookRepository.searchByISBN(999999);
        assertEquals(0, bookRepository.booksFound);
    }
}