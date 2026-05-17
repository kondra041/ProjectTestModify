package generated;

import java.io.IOException;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import projectTestModify.SimpleChat.Client;
import projectTestModify.SimpleChat.IncomingReader;
import projectTestModify.SimpleChat.SendButtonListener;

public class ClientTest {

    @Test
    public void testSetUpNetworking() throws IOException {
        Client client = new Client();
        Socket mockSocket = mock(Socket.class);
        InputStreamReader mockStreamReader = mock(InputStreamReader.class);
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        when(new Socket("192.168.5.16", 5000)).thenReturn(mockSocket);
        when(mockSocket.getInputStream()).thenReturn(mockInputStreamReader);
        when(mockInputStreamReader.getEncoding()).thenReturn("UTF-8");
        when(mockSocket.getOutputStream()).thenReturn(mockOutputStreamWriter);

        client.setUpNetworking();

        verify(mockSocket).connect(any(SocketAddress.class));
        verify(mockInputStreamReader).close();
        verify(mockPrintWriter).close();
    }

    @Test
    public void testSendButtonListenerAction() {
        Client client = new Client();
        JTextField mockJTextField = mock(JTextField.class);
        PrintWriter mockPrintWriter = mock(PrintWriter.class);

        SendButtonListener sendButtonListener = client.new SendButtonListener();
        sendButtonListener.actionPerformed(mockActionEvent());

        verify(mockPrintWriter).println(anyString());
        verify(mockPrintWriter).flush();
        verify(mockJTextField).setText("");
        verify(mockJTextField).requestFocus();
    }

    @Test
    public void testIncomingReaderRun() throws IOException {
        Client client = new Client();
        BufferedReader mockBufferedReader = mock(BufferedReader.class);

        IncomingReader incomingReader = client.new IncomingReader();
        incomingReader.reader = mockBufferedReader;

        when(mockBufferedReader.readLine()).thenReturn("test message").thenReturn(null);

        incomingReader.run();

        verify(mockBufferedReader).readLine();
        verify(client.incoming).append("test message\n");
    }

    private ActionEvent mockActionEvent() {
        return new ActionEvent(new Object(), 0, "");
    }
}