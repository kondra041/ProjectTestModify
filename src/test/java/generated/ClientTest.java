package generated;

import projectTestModify.SimpleChat.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.*;
import javax.swing.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;
    private Socket mockSocket;
    private PrintWriter mockWriter;
    private BufferedReader mockReader;

    @BeforeEach
    public void setUp() throws Exception {
        mockSocket = mock(Socket.class);
        mockWriter = mock(PrintWriter.class);
        mockReader = mock(BufferedReader.class);
        when(mockSocket.getInputStream()).thenReturn(new ByteArrayInputStream("test\n".getBytes()));
        when(mockSocket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
        client = new Client();
    }

    @Test
    public void testSendMessage() throws Exception {
        // Arrange
        client.sock = mockSocket;
        client.writer = mockWriter;
        client.outgoing = new JTextField("test message");

        // Act
        client.new SendButtonListener().actionPerformed(null);

        // Assert
        verify(mockWriter).println("test message");
        verify(mockWriter).flush();
    }

    @Test
    public void testReceiveMessage() throws Exception {
        // Arrange
        client.reader = mockReader;
        client.incoming = new JTextArea();

        // Act
        client.new IncomingReader().run();

        // Assert
        assertEquals("test\n", client.incoming.getText());
    }
}