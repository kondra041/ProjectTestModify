package generated;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookRepositoryTest {

    private BookRepository bookRepository = new BookRepository();

    @Test
    public void testSearchByTitle() {
        int expectedBooksFound = 2; // Based on the provided data, "Love" appears in two books' titles.
        bookRepository.searchByTitle("love");
        assertEquals(expectedBooksFound, bookRepository.booksFound);
    }

    @Test
    public void testSearchByISBN() {
        int isbn = 253910;
        boolean expectedBookExists = true; // ISBN 253910 exists in the provided data.
        boolean isBookFound = bookRepository.searchISBN(isbn) == 1;
        assertEquals(expectedBookExists, isBookFound);
    }

    @Test
    public void testSearchByGenre() {
        String genre = "Educational";
        int expectedBooksFound = 2; // Based on the provided data, two books are in the 'Educational' genre.
        boolean bookGenreExist = bookRepository.searchByGenre(genre);
        assertTrue(bookGenreExist);
    }

    @Test
    public void testGetBook() {
        int isbn = 391520;
        boolean expectedAvailability = true; // ISBN 391520 has available quantity (more than checked out).
        boolean bookAvailable = bookRepository.getBook(isbn);
        assertEquals(expectedAvailability, bookAvailable);
    }

    @Test
    public void testSubmitBook() {
        int isbn = 715332;
        boolean expectedReturnStatus = true; // ISBN 715332 has a checked out status (checkedOut > 0).
        boolean bookReturnedSuccessfully = bookRepository.submitBook(isbn);
        assertEquals(expectedReturnStatus, bookReturnedSuccessfully);
    }
}