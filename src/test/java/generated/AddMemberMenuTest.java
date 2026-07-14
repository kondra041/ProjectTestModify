package generated;

import java.sql.Connection;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.libraryManagement.AddMemberMenu;
import projectTestModify.libraryManagement.Member;
import projectTestModify.libraryManagement.LibUtil;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddMemberMenuTest {

    @BeforeEach
    public void setUp() {
        // Set up any necessary mocks or configurations before each test
    }

    @Test
    public void testAddMemberMenu() {
        Scanner mockScanner = new Scanner("1\nJohn Doe");
        when(LibUtil.getConnection()).thenReturn(mockConnection);

        AddMemberMenu.addMemberMenu();

        verify(mockConnection, times(1)).commit();
        verify(mockConnection, never()).rollback();
    }

    @Test
    public void testAddMemberMenuException() {
        Scanner mockScanner = new Scanner("abc\nJohn Doe");
        when(LibUtil.getConnection()).thenReturn(mockConnection);

        AddMemberMenu.addMemberMenu();

        verify(mockConnection, times(1)).rollback();
    }
}