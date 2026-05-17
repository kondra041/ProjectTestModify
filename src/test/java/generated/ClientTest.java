package generated;

import projectTestModify.SimpleChat.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientTest {

    @Mock
    private Socket sock;

    @Mock
    private BufferedReader reader;

    @Mock
    private PrintWriter writer;

    private Client client;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.reader = reader;
        client.writer = writer;
        client.sock = sock;
    }

    @Test
    public void testSetUpNetworking() throws IOException {
        when(sock.getInputStream()).thenReturn(mock(InputStreamReader.class));
        when(sock.getOutputStream()).thenReturn(mock(PrintWriter.class));

        client.setUpNetworking();

        verify(sock).connect(new java.net.InetSocketAddress("192.168.5.16", 5000));
        assertNotNull(client.reader);
        assertNotNull(client.writer);
    }

    @Test
    public void testSendButtonListener() {
        Client.SendButtonListener listener = client.new SendButtonListener();
        mockStatic(System.class);

        listener.actionPerformed(mock(ActionEvent.class));

        verify(writer).println(anyString());
        verify(writer).flush();
    }

    @Test
    public void testIncomingReader() throws IOException {
        when(reader.readLine()).thenReturn("test message", null);

        Client.IncomingReader reader = client.new IncomingReader();
        new Thread(reader).start();

        try {
            Thread.sleep(100); // Allow time for the thread to run
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        verify(incoming).append("test message\n");
    }
}