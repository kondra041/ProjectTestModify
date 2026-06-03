package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;

class BookRepositoryTest {

    @Test
    void searchByISBN_ExistingBookFound() {
        BookRepository repository = new BookRepository();
        repository.searchByISBN(391520);
        assertEquals(1, repository.booksFound);
    }
    @Test
    void searchByISBN_NonExistingBookFound() {
        BookRepository repository = new BookRepository();
        repository.searchByISBN(123456789);
        assertEquals(0, repository.booksFound);
    }
}