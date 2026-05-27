package generated;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    @org.junit.jupiter.api.Test
    public void testAddMemberMenu() {
        Scanner mockScanner = new Scanner("123\nJohn Doe");
        Member mockMember = mock(Member.class);
        LibUtil mockLibUtil = mock(LibUtil.class);
        Connection mockConnection = mock(Connection.class);
        Statement mockStatement = mock(Statement.class);

        when(mockLibUtil.getConnection()).thenReturn(mockConnection);
        when(mockScanner.nextLine()).thenReturn("123").thenReturn("John Doe");
        doNothing().when(mockMember).setMemberId(123);
        doNothing().when(mockMember).setMemberName("John Doe");

        AddMemberMenu.addMemberMenu();

        verify(mockScanner, times(2)).nextLine();
        verify(mockMember, times(1)).setMemberId(123);
        verify(mockMember, times(1)).setMemberName("John Doe");
        verify(mockLibUtil, times(1)).getConnection();
        verify(mockConnection, times(1)).createStatement();
        verify(mockStatement, times(1)).executeUpdate("insert into members values (123,'John Doe',sysdate)");
        verify(mockConnection, times(1)).commit();
    }
}