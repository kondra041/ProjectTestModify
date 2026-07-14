package generated;

   import projectTestModify.libraryApp.BookRepository;
   import projectTestModify.libraryApp.Book;
   import static org.junit.jupiter.api.Assertions.*;
   import static org.mockito.Mockito.*;
   import org.junit.jupiter.api.BeforeEach;
   import org.junit.jupiter.api.Test;

   public class BookRepositoryTest {
       private BookRepository bookRepository;

       @BeforeEach
       void setUp() {
           bookRepository = new BookRepository();
       }

       @Test
       void testSearchByTitle() {
           int foundBooks = bookRepository.searchByTitle("Pride and Prejudice C");
           assertEquals(1, foundBooks);
       }

       @Test
       void testSearchByISBN() {
           int foundBooks = bookRepository.searchByISBN(391520);
           assertEquals(1, foundBooks);
       }

       @Test
       void testSearchByGenre() {
           boolean genreFound = bookRepository.searchByGenre("Educational");
           assertTrue(genreFound);
       }

       @Test
       void testSearchISBN() {
           int isbnFound = bookRepository.searchISBN(715332);
           assertEquals(1, isbnFound);
       }

       @Test
       void testGetBook() {
           boolean bookGotten = bookRepository.getBook(935141);
           assertTrue(bookGotten);
       }

       @Test
       void testSubmitBook() {
           boolean bookSubmitted = bookRepository.submitBook(855141);
           assertTrue(bookSubmitted);
       }
   }