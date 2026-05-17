package generated;

import projectTestModify.SimpleChat.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static org.mockito.Mockito.*;

public class ClientTest {

    private Client client;
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket sock;

    @BeforeEach
    public void setUp() {
        client = new Client();
        incoming = mock(JTextArea.class);
        outgoing = mock(JTextField.class);
        reader = mock(BufferedReader.class);
        writer = mock(PrintWriter.class);
        sock = mock(Socket.class);

        when(client.sock).thenReturn(sock);
        when(client.reader).thenReturn(reader);
        when(client.writer).thenReturn(writer);
    }

    @Test
    public void testGo() {
        client.go();
        verify(new JFrame("Ludicrously Simple Chat Client")).setVisible(true);
        verify(new JPanel()).add(any(JScrollPane.class));
        verify(new JPanel()).add(outgoing);
        verify(new JPanel()).add(new JButton("Send"));
        verify(client).setUpNetworking();
    }

    @Test
    public void testSetUpNetworking() {
        client.setUpNetworking();
        verify(sock).connect(eq(new java.net.InetSocketAddress("192.168.5.16", 5000)));
        verify(reader).readLine();
        verify(writer).println(anyString());
        verify(writer).flush();
    }

    @Test
    public void testSendButtonListenerActionPerformed() {
        client.outgoing.setText("test message");
        client.new SendButtonListener().actionPerformed(mock(ActionEvent.class));
        verify(client.writer).println("test message");
        verify(client.writer).flush();
        verify(client.outgoing).setText("");
        verify(client.outgoing).requestFocus();
    }

    @Test
    public void testIncomingReaderRun() throws IOException {
        when(reader.readLine()).thenReturn("test message").thenReturn(null);
        client.new IncomingReader().run();
        verify(client.incoming).append("test message\n");
    }
}