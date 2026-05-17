package generated;

   import org.junit.jupiter.api.Test;
   import projectTestModify.libraryApp.BookRepository;

   import java.io.ByteArrayOutputStream;
   import java.io.PrintStream;

   import static org.junit.jupiter.api.Assertions.*;

   public class BookRepositoryTest {
       @Test
       void testSearchByISBN() {
           ByteArrayOutputStream outContent = new ByteArrayOutputStream();
           System.setOut(new PrintStream(outContent));

           BookRepository repository = new BookRepository();
           repository.searchByISBN(391520);

           String expectedOutput = "\n1 Book Found.\n";
           assertEquals(expectedOutput, outContent.toString());
       }
   }