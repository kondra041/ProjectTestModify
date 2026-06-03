package generated;

import org.junit.jupiter.api.Test;
import projectTestModify.libraryApp.BookRepository;
import projectTestModify.libraryApp.Book;
import java.util.ArrayList;

public class BookRepositoryTest {

    @Test
    public void searchByTitle() {
        BookRepository bookRepo = new BookRepository();
        String title = "Pride and Prejudice";
        int expectedResult = 1;

        // Act
        bookRepo.searchByTitle(title);
        int actualResult = bookRepo.booksFound;

        // Assert
        assertEquals(expectedResult, actualResult);
    }
}