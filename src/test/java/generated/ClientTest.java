import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import projectTestModify.SimpleChat.Client;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Mock
    private Socket sock;
    
    @Mock
    private BufferedReader reader;
    
    @Mock
    private PrintWriter writer;
    
    @InjectMocks
    private Client client;

    @BeforeEach
    void setUp() {
        when(sock.getInputStream()).thenReturn(mock(java.io.InputStream.class));
        when(sock.getOutputStream()).thenReturn(mock(java.io.OutputStream.class));
        when(new BufferedReader(new InputStreamReader(sock.getInputStream()))).thenReturn(reader);
        when(new PrintWriter(sock.getOutputStream())).thenReturn(writer);
    }

    @Test
    void testSetUpNetworking() {
        assertDoesNotThrow(() -> client.setUpNetworking());
        verify(sock).connect(any(SocketAddress.class));
        verify(reader).readLine();
    }

    @Test
    void testIncomingReader() throws IOException {
        String testMessage = "test";
        when(reader.readLine()).thenReturn(testMessage);
        
        client.client.incoming.append(testMessage + "\n");
        
        verify(reader).readLine();
    }
}