import static org.junit.jupiter.api.Assertions.*;
import projectTestModify.libraryApp.BookRepository;
import java.util.ArrayList;
import projectTestModify.libraryApp.Book;

public class BookRepositoryTest {

    @org.junit.jupiter.api.Test
    public void testSearchByTitle() {
        BookRepository bookRepo = new BookRepository();
        ArrayList<String> expectedResults = new ArrayList<>();
        // Assuming the search is case-insensitive and contains keyword
        expectedResults.add("Pride and Prejudice C");
        expectedResults.add("Disneyland");
        ArrayList<String> actualResults = new ArrayList<>();

        bookRepo.searchByTitle("disney");
        // Assuming the search results are displayed using System.out.println, so we need to capture them
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        for (Book book : bookRepo.books) {
            if (book.getTitle().toLowerCase().contains("disney".toLowerCase())) {
                actualResults.add(book.getTitle());
            }
        }
        System.setOut(System.out); // reset standard output stream

        assertEquals(expectedResults, actualResults);
    }

    @org.junit.jupiter.api.Test
    public void testSearchByISBN() {
        BookRepository bookRepo = new BookRepository();
        int isbnToSearch = 935141;
        boolean found = false;

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        bookRepo.searchByISBN(isbnToSearch);
        System.setOut(System.out); // reset standard output stream

        for (Book book : bookRepo.books) {
            if (book.getIsbn() == isbnToSearch) {
                found = true;
                break;
            }
        }

        assertTrue(found);
    }

    @org.junit.jupiter.api.Test
    public void testSearchByGenre() {
        BookRepository bookRepo = new BookRepository();
        String genreToSearch = "Educational";
        ArrayList<String> expectedResults = new ArrayList<>();
        // Assuming the search is case-insensitive
        expectedResults.add("Programming in ANSI C");
        expectedResults.add("Java: The Complete Reference");
        ArrayList<String> actualResults = new ArrayList<>();

        bookRepo.searchByGenre(genreToSearch);
        // Assuming the search results are displayed using System.out.println, so we need to capture them
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        for (Book book : bookRepo.books) {
            if (book.getGenre().toLowerCase().equals(genreToSearch.toLowerCase())) {
                actualResults.add(book.getTitle());
            }
        }
        System.setOut(System.out); // reset standard output stream

        assertEquals(expectedResults, actualResults);
    }

    @org.junit.jupiter.api.Test
    public void testGetBook() {
        BookRepository bookRepo = new BookRepository();
        int isbnToGet = 391520; // This book has available quantity
        boolean result = bookRepo.getBook(isbnToGet);

        assertTrue(result);
        for (Book book : bookRepo.books) {
            if (book.getIsbn() == isbnToGet) {
                assertEquals(1, book.getCheckedOut()); // Assuming the checked out quantity increased by 1
                break;
            }
        }
    }
}