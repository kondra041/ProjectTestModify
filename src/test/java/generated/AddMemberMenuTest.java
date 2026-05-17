package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddMemberMenuTest {

    @Mock
    private Connection conn;

    @Mock
    private Statement stmt;

    @InjectMocks
    private Member m;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddMemberSuccess() throws Exception {
        when(LibUtil.getConnection()).thenReturn(conn);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate(anyString())).thenReturn(1);

        AddMemberMenu.addMember(m);

        verify(conn).commit();
        verify(conn).close();
    }

    @Test
    void testAddMemberFailure() throws Exception {
        when(LibUtil.getConnection()).thenReturn(conn);
        when(conn.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate(anyString())).thenReturn(0);

        AddMemberMenu.addMember(m);

        verify(conn).rollback();
        verify(conn).close();
    }
}