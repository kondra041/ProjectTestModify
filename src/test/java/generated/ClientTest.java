import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;
import projectTestModify.SimpleChat.Client;

class TestClient {

    @Test
    void testGo() {
        // Mock dependencies
        JFrame mockFrame = mock(JFrame.class);
        JPanel mockPanel = mock(JPanel.class);
        JTextArea mockIncoming = mock(JTextArea.class);
        JTextField mockOutgoing = mock(JTextField.class);
        JScrollPane mockScrollPane = mock(JScrollPane.class);
        JButton mockSendButton = mock(JButton.class);
        
        BufferedReader mockReader = mock(BufferedReader.class);
        PrintWriter mockWriter = mock(PrintWriter.class);
        Socket mockSock = mock(Socket.class);

        // Create Client instance
        Client client = new Client();

        // Use reflection to set final fields for testing purposes
        try {
            java.lang.reflect.Field incomingField = Client.class.getDeclaredField("incoming");
            incomingField.setAccessible(true);
            incomingField.set(client, mockIncoming);

            java.lang.reflect.Field outgoingField = Client.class.getDeclaredField("outgoing");
            outgoingField.setAccessible(true);
            outgoingField.set(client, mockOutgoing);

            java.lang.reflect.Field readerField = Client.class.getDeclaredField("reader");
            readerField.setAccessible(true);
            readerField.set(client, mockReader);

            java.lang.reflect.Field writerField = Client.class.getDeclaredField("writer");
            writerField.setAccessible(true);
            writerField.set(client, mockWriter);

            java.lang.reflect.Field sockField = Client.class.getDeclaredField("sock");
            sockField.setAccessible(true);
            sockField.set(client, mockSock);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        // Call go() method
        client.go();

        // Verify interactions
        verify(mockFrame).setSize(400, 500);
        verify(mockFrame).setContentPane(any());
        verify(mockFrame).setVisible(true);

        verify(mockPanel).add(any());

        verify(mockScrollPane).setVerticalScrollBarPolicy(anyInt());
        verify(mockScrollPane).setHorizontalScrollBarPolicy(anyInt());

        verify(mockSendButton).addActionListener(any());

        // Verify networking setup
        verify(mockSock).getInputStream();
        verify(mockSock).getOutputStream();

        // Verify thread creation and start
        verify(mockReader, atLeastOnce()).readLine();
    }
}