package generated;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientTest {

    @Test
    public void testGoMethod() {
        // Mock dependencies
        JFrame frameMock = mock(JFrame.class);
        JPanel mainPanelMock = mock(JPanel.class);
        JTextArea incomingMock = mock(JTextArea.class);
        JTextField outgoingMock = mock(JTextField.class);
        JButton sendButtonMock = mock(JButton.class);
        JScrollPane qScrollerMock = mock(JScrollPane.class);
        Socket socketMock = mock(Socket.class);
        BufferedReader readerMock = mock(BufferedReader.class);
        PrintWriter writerMock = mock(PrintWriter.class);

        // Create instance of Client
        Client client = new Client();

        // Inject mocks into client instance
        try {
            Field field = Client.class.getDeclaredField("sock");
            field.setAccessible(true);
            field.set(client, socketMock);

            field = Client.class.getDeclaredField("reader");
            field.setAccessible(true);
            field.set(client, readerMock);

            field = Client.class.getDeclaredField("writer");
            field.setAccessible(true);
            field.set(client, writerMock);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to inject mocks into client instance");
        }

        // Mock JFrame behavior
        when(frameMock.getContentPane()).thenReturn(mainPanelMock);

        // Mock JTextArea behavior
        when(incomingMock.getLineWrap()).thenReturn(true);
        when(incomingMock.getWrapStyleWord()).thenReturn(true);
        when(incomingMock.isEditable()).thenReturn(false);

        // Mock JScrollPane behavior
        when(qScrollerMock.setVerticalScrollBarPolicy(anyInt())).thenReturn(qScrollerMock);
        when(qScrollerMock.setHorizontalScrollBarPolicy(anyInt())).thenReturn(qScrollerMock);

        // Mock JTextField behavior
        when(outgoingMock.getText()).thenReturn("Test message");

        // Mock JButton behavior
        doNothing().when(sendButtonMock).addActionListener(any(ActionListener.class));

        // Call go method
        client.go();

        // Verify JFrame setup
        verify(frameMock, times(1)).setTitle("Ludicrously Simple Chat Client");
        verify(frameMock, times(1)).setSize(400, 500);
        verify(frameMock, times(1)).setVisible(true);

        // Verify JPanel setup
        verify(mainPanelMock, times(1)).add(qScrollerMock);
        verify(mainPanelMock, times(1)).add(outgoingMock);
        verify(mainPanelMock, times(1)).add(sendButtonMock);

        // Verify JScrollPane setup
        verify(qScrollerMock, times(1)).setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        verify(qScrollerMock, times(1)).setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Verify JTextArea setup
        verify(incomingMock, times(1)).setLineWrap(true);
        verify(incomingMock, times(1)).setWrapStyleWord(true);
        verify(incomingMock, times(1)).setEditable(false);

        // Verify JButton setup
        verify(sendButtonMock, times(1)).addActionListener(any(ActionListener.class));

        // Verify networking setup
        try {
            Field field = Client.class.getDeclaredField("sock");
            field.setAccessible(true);
            Socket sock = (Socket) field.get(client);
            assertEquals(socketMock, sock);

            field = Client.class.getDeclaredField("reader");
            field.setAccessible(true);
            BufferedReader reader = (BufferedReader) field.get(client);
            assertEquals(readerMock, reader);

            field = Client.class.getDeclaredField("writer");
            field.setAccessible(true);
            PrintWriter writer = (PrintWriter) field.get(client);
            assertEquals(writerMock, writer);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to verify networking setup");
        }
    }
}