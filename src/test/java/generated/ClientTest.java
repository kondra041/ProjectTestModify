package generated;

import projectTestModify.SimpleChat.Client;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientTest {

    @org.junit.jupiter.api.Test
    void testGo() throws IOException {
        Client client = mock(Client.class);
        when(client.go()).thenCallRealMethod();
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        assertEquals(frame.getTitle(), "Ludicrously Simple Chat Client");
    }

    @org.junit.jupiter.api.Test
    void testSetUpNetworking() throws IOException {
        Client client = new Client();
        Socket socket = mock(Socket.class);
        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream("test".getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());
        try (MockedStatic<Socket> mockedStatic = Mockito.mockStatic(Socket.class)) {
            mockedStatic.when(() -> Socket.newInstance(anyString(), anyInt())).thenReturn(socket);
            client.setUpNetworking();
            assertNotNull(client.reader);
            assertNotNull(client.writer);
        }
    }

    @org.junit.jupiter.api.Test
    void testSendButtonListener() {
        Client client = new Client();
        client.outgoing = mock(JTextField.class);
        client.writer = mock(PrintWriter.class);
        ActionEvent event = mock(ActionEvent.class);
        Client.SendButtonListener listener = client.new SendButtonListener();
        listener.actionPerformed(event);
        verify(client.writer).println(anyString());
        verify(client.writer).flush();
    }
}