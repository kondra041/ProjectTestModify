import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Spy;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;

public class AddMemberMenuTest {
    @Mock
    private Connection connection;
    @Mock
    private Statement statement;
    @Spy
    private Scanner scanner = new Scanner(System.in);
    
    private Member member;
    
    @BeforeEach
    void setUp() {
        member = new Member();
    }
    
    @Test
    void addMemberMenuShouldDisplayMessageAndProceedSuccessfully() throws Exception {
        when(scanner.nextLine()).thenReturn("123").thenReturn("John Doe");
        doReturn(statement).when(connection).createStatement();
        doReturn(1).when(statement).executeUpdate(anyString());
        
        Executable executable = () -> AddMemberMenu.addMemberMenu();
        
        assertDoesNotThrow(executable);
        verify(scanner, times(2)).nextLine();
        verify(connection).commit();
    }
    
    @Test
    void addMemberShouldHandleExceptionWhenDuplicateId() {
        when(scanner.nextLine()).thenReturn("1").thenReturn("John Doe");
        doReturn(statement).when(connection).createStatement();
        doThrow(new SQLException("Duplicate entry")).when(statement).executeUpdate(anyString());
        
        Executable executable = () -> AddMemberMenu.addMemberMenu();
        
        assertAll(
            () -> verify(scanner, times(2)).nextLine(),
            () -> verify(connection).rollback()
        );
    }
    
    @Test
    void addMemberShouldHandleInvalidScannerInput() {
        when(scanner.nextLine()).thenReturn("abc").thenReturn("John Doe");
        
        Executable executable = () -> AddMemberMenu.addMemberMenu();
        
        assertThrows(Exception.class, executable);
    }
}