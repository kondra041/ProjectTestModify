import generated.AddMemberMenu;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.Statement;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AddMemberMenuTest {

    @Test
    public void testAddMemberMenu() throws Exception {
        String input = "123\nJohn Doe\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try (MockedStatic<LibUtil> util = mockStatic(LibUtil.class)) {
            Connection mockConn = mock(Connection.class);
            Statement mockStmt = mock(Statement.class);
            when(mockConn.createStatement()).thenReturn(mockStmt);
            when(mockStmt.executeUpdate(anyString())).thenReturn(1);
            util.when(LibUtil::getConnection).thenReturn(mockConn);

            AddMemberMenu.addMemberMenu();

            verify(mockStmt, times(1)).executeUpdate("insert into members values (123,'John Doe',sysdate)");
        }
    }
}