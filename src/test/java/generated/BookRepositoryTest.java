package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void searchByISBNTest() {
        int isbn = 391520;
        bookRepository.searchByISBN(isbn);

        assertEquals(1, bookRepository.booksFound);
    }
}