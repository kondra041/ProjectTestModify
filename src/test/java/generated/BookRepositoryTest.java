package generated;

   import projectTestModify.libraryApp.BookRepository;
   import projectTestModify.libraryApp.Book;

   import static org.junit.jupiter.api.Assertions.*;
   import static org.mockito.Mockito.*;

   import org.junit.jupiter.api.BeforeEach;
   import org.junit.jupiter.api.Test;
   import org.mockito.InjectMocks;
   import org.mockito.Mock;
   import org.mockito.MockitoAnnotations;

   import java.util.ArrayList;

   class BookRepositoryTest {
       @Mock
       private Book book;

       @InjectMocks
       private BookRepository bookRepository = new BookRepository();

       @BeforeEach
       void setUp() {
           MockitoAnnotations.initMocks(this);
       }

       @Test
       void testSearchByGenre_Successful() {
           String genre = "Love";
           when(book.getGenre()).thenReturn("Love");

           boolean result = bookRepository.searchByGenre(genre);

           assertTrue(result);
       }
   }