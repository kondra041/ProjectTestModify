package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testSearchByTitle() {
        String title = "Pride and Prejudice";
        int expectedBooksFound = 1;
        try (MockedStatic<Book> mockedBook = mockStatic(Book.class)) {
            mockedBook.when(Book::getTitle).thenReturn("Pride and Prejudice");
            bookRepository.searchByTitle(title);
            assertEquals(expectedBooksFound, bookRepository.booksFound);
        }
    }

    @Test
    void testSearchByISBN() {
        int isbn = 253910;
        int expectedBooksFound = 1;
        try (MockedStatic<Book> mockedBook = mockStatic(Book.class)) {
            mockedBook.when(() -> new Book(isbn, "Pride and Prejudice", "Jane Austen", "Love", 10, 7).getIsbn())
                      .thenReturn(isbn);
            bookRepository.searchByISBN(isbn);
            assertEquals(expectedBooksFound, bookRepository.booksFound);
        }
    }

    @Test
    void testSearchByGenre() {
        String genre = "Love";
        boolean expectedFound = true;
        try (MockedStatic<Book> mockedBook = mockStatic(Book.class)) {
            mockedBook.when(() -> new Book(253910, "Pride and Prejudice", "Jane Austen", genre, 10, 7).getGenre())
                      .thenReturn(genre);
            boolean result = bookRepository.searchByGenre(genre);
            assertEquals(expectedFound, result);
        }
    }
}