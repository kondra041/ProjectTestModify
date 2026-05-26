package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectTestModify.SimpleChat.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientTest {

    private Client client;
    private Socket mockSocket;
    private BufferedReader mockReader;
    private PrintWriter mockWriter;

    @BeforeEach
    public void setUp() {
        client = new Client();
        mockSocket = mock(Socket.class);
        mockReader = mock(BufferedReader.class);
        mockWriter = mock(PrintWriter.class);

        try {
            when(mockSocket.getInputStream()).thenReturn(new java.io.ByteArrayInputStream("".getBytes()));
            when(mockSocket.getOutputStream()).thenReturn(new java.io.ByteArrayOutputStream());
            when(mockSocket.getInetAddress()).thenReturn(java.net.InetAddress.getLocalHost());
            when(mockSocket.getPort()).thenReturn(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.sock = mockSocket;
        client.reader = new BufferedReader(mockReader);
        client.writer = mockWriter;
    }

    @Test
    public void testGo() {
        // Call the go method
        client.go();

        // Verify that networking was established
        verify(mockSocket).getInputStream();
        verify(mockSocket).getOutputStream();
    }

    @Test
    public void testSetUpNetworking() throws IOException {
        // Call the setUpNetworking method
        client.setUpNetworking();

        // Verify that the socket is created and connected
        assertNotNull(client.sock);
        assertTrue(client.sock.isConnected());
    }
}