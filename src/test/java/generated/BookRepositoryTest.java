package generated;

import <projectTestModify.libraryApp>.BookRepository;
import org.junit.jupiter.api.Test;

class BookRepositoryTest {

    @Test
    void testSearchByISBN() {
        BookRepository bookRepository = new BookRepository();
        bookRepository.searchByISBN(715332); 
        // assertions here
    }
}