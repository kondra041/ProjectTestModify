package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import projectTestModify.libraryApp.Book;
import projectTestModify.libraryApp.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBookRepositorySearchGenre {

    private BookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new BookRepository();
    }

    @Test
    void testSearchByGenreNotFound() {
        boolean result = repository.searchByGenre("Science Fiction");
        System.out.println("Testing genre 'Science Fiction' not found:");
        assertEquals(false, result);
        System.out.printf("Books Found: %d\n", repository.booksFound);
    }

    @Test
    void testSearchByGenreExactMatch() {
        boolean result = repository.searchByGenre("Horror");
        System.out.println("\nTesting genre ' Horror'");
        assertEquals(true, result);
        System.out.printf("Books Found: %d\n", repository.booksFound);
    }

    @Test
    void testSearchByGenreMultipleMatches() {
        boolean result = repository.searchByGenre("Educational");
        System.out.println("\nTesting genre 'Educational'");
        assertEquals(true, result);
        System.out.printf("Books Found: %d\n", repository.booksFound);
    }
}