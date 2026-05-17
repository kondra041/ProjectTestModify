package generated;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;
import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class AddMemberMenuTest {

    @Mock
    private Scanner scannerMock;

    @InjectMocks
    private AddMemberMenu addMemberMenu;

    @Test
    public void testAddMemberMenu() {
        // Mock user input
        when(scannerMock.nextLine()).thenReturn("1", "John Doe");

        // Call the method under test
        addMemberMenu.addMemberMenu();

        // Assertions can be added here if needed
    }
}