package generated;

import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.Test;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void getBookTest() {
        int isbn = 253910;
        boolean result = bookRepository.getBook(isbn);

        assertTrue(result);
        assertEquals(1, bookRepository.books.get(0).getCheckedOut());
    }
}