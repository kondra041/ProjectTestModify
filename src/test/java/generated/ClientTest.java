package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientTest {

    @Mock
    private Socket mockSocket;

    @Mock
    private BufferedReader mockReader;

    @Mock
    private PrintWriter mockWriter;

    private Client client;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.sock = mockSocket;
        when(mockSocket.getInputStream()).thenReturn(new java.io.InputStream() {
            @Override
            public int read() throws IOException {
                return -1; // Simulate end of stream
            }
        });
        when(mockSocket.getOutputStream()).thenReturn(new java.io.OutputStream() {
            @Override
            public void write(int b) throws IOException {}
        });
    }

    @Test
    public void testGoMethod() {
        JFrame frame = client.go();
        assertNotNull(frame);
        assertEquals("Ludicrously Simple Chat Client", frame.getTitle());
        assertTrue(frame.isVisible());
    }

    @Test
    public void testSetUpNetworking() throws IOException {
        client.sock = mockSocket;
        when(mockSocket.getInputStream()).thenReturn(new java.io.InputStream() {
            @Override
            public int read() throws IOException {
                return -1; // Simulate end of stream
            }
        });
        when(mockSocket.getOutputStream()).thenReturn(new java.io.OutputStream() {
            @Override
            public void write(int b) throws IOException {}
        });

        client.setUpNetworking();

        assertNotNull(client.reader);
        assertNotNull(client.writer);
    }

    @Test
    public void testSendButtonListener() {
        JTextArea incoming = new JTextArea();
        JTextField outgoing = new JTextField("Hello");
        JButton sendButton = new JButton("Send");
        SendButtonListener listener = client.new SendButtonListener();

        listener.actionPerformed(new java.awt.event.ActionEvent(sendButton, 1, ""));

        assertEquals("", outgoing.getText());
    }

    @Test
    public void testIncomingReader() throws IOException {
        JTextArea incoming = new JTextArea();
        BufferedReader reader = mock(BufferedReader.class);
        PrintWriter writer = mock(PrintWriter.class);
        Socket socket = mock(Socket.class);

        when(socket.getInputStream()).thenReturn(new java.io.InputStream() {
            @Override
            public int read() throws IOException {
                return -1; // Simulate end of stream
            }
        });

        IncomingReader incomingReader = client.new IncomingReader();
        Thread readerThread = new Thread(incomingReader);
        readerThread.start();

        try {
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        verify(reader, times(1)).close();
    }
}