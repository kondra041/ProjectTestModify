package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.LibUtil;
import projectTestModify.libraryManagement.Member;

public class AddMemberMenuTest {

    @Mock
    private Connection conn;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddMemberMenu() {
        // Arrange
        Scanner sc = mock(Scanner.class);
        Member m = new Member();
        when(sc.nextLine()).thenReturn("123", "John Doe");
        when(LibUtil.getConnection()).thenReturn(conn);

        // Act
        AddMemberMenu.addMemberMenu();

        // Assert
        verify(sc, times(2)).nextLine();
        verify(conn).createStatement();
        verify(conn).commit();
        verifyNoMoreInteractions(conn);
    }

    @Test
    public void testAddMemberException() {
        // Arrange
        Scanner sc = mock(Scanner.class);
        Member m = new Member();
        when(sc.nextLine()).thenReturn("123", "John Doe");
        when(LibUtil.getConnection()).thenReturn(conn);
        doThrow(new RuntimeException()).when(conn).createStatement();

        // Act & Assert
        assertThrows(RuntimeException.class, () -> AddMemberMenu.addMemberMenu());
    }
}