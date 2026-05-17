import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;

@ExtendWith(MockitoExtension.class)
public class AddMemberMenuTest {

    @Mock
    private Scanner mockScanner;
    
    @Mock
    private Connection mockConnection;

    @InjectMocks
    private AddMemberMenu addMemberMenu;

    @BeforeEach
    void setUp() {
        clear mocks();
    }

    @Test
    void testAddMemberMenuShouldAddMemberSuccessfully() {
        when(mockScanner.nextLine()).thenReturn("123").thenReturn("John Doe");
        
        Member member = new Member();
        member.setMemberId(123);
        member.setMemberName("John Doe");

        AddMemberMenu.addMember(member);

        verify(mockConnection).createStatement();
        verify(mockConnection).executeUpdate("insert into members values (123,'John Doe',sysdate)");
    }

    @Test
    void testAddMemberMenuShouldHandleInvalidInput() {
        when(mockScanner.nextLine()).thenReturn("abc").thenThrow(new NumberFormatException());
        
        assertThrows(Exception.class, () -> AddMemberMenu.addMemberMenu());
    }
}