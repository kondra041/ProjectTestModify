package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;

class BookRepositoryTest {

    @Test
    void testSearchByGenre() {
        BookRepository bookRepository = new BookRepository();
        assertTrue(bookRepository.searchByGenre("Motivational"));
        assertFalse(bookRepository.searchByGenre("Romance"));
    }
}