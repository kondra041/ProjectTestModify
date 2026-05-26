import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import projectTestModify.SimpleChat.Client;

@ExtendWith(MockitoExtension.class)
class ClientTest {

    @InjectMocks
    private Client client;

    @Test
    void testSetUpNetworking() {
        // Mock the socket creation
        when(new Socket("192.168.5.16", 5000)).thenReturn(mock(Socket.class));

        // Call go method
        client.go();

        // Verify that setUpNetworking was called
        verify(client).setUpNetworking();
    }
}