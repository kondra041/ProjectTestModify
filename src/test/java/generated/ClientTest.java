package generated;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientTest {

    private Client client;
    private Socket mockSocket;
    private BufferedReader mockReader;
    private PrintWriter mockWriter;

    @BeforeEach
    void setUp() {
        client = new Client();
        mockSocket = Mockito.mock(Socket.class);
        mockReader = Mockito.mock(BufferedReader.class);
        mockWriter = Mockito.mock(PrintWriter.class);

        try {
            when(mockSocket.getInputStream()).thenReturn(new InputStreamReader(System.in));
            when(mockSocket.getOutputStream()).thenReturn(System.out);
            doNothing().when(mockWriter).flush();
        } catch (IOException e) {
            fail("Exception in setup");
        }

        client.sock = mockSocket;
        client.reader = mockReader;
        client.writer = mockWriter;
    }

    @Test
    void testSetUpNetworking() {
        try {
            client.setUpNetworking();
            verify(mockSocket).connect(any(InetSocketAddress.class));
            verify(mockReader).<BufferedReader>anything();
            verify(mockWriter).<PrintWriter>anything();
        } catch (IOException e) {
            fail("Exception in test");
        }
    }
}