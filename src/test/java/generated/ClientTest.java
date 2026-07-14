package generated;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import projectTestModify.SimpleChat.Client;

public class ClientTest {

    @Test
    public void testGo() {
        JFrame frame = mock(JFrame.class);
        JPanel mainPanel = mock(JPanel.class);
        JTextArea incoming = mock(JTextArea.class);
        JTextField outgoing = mock(JTextField.class);
        JButton sendButton = mock(JButton.class);
        SendButtonListener listener = mock(Client.SendButtonListener.class);
        IncomingReader reader = mock(Client.IncomingReader.class);

        when(sendButton.addActionListener(any(ActionListener.class))).thenReturn(null);

        Client client = new Client();
        doNothing().when(client).setUpNetworking();

        client.go();

        verify(frame).setTitle("Ludicrously Simple Chat Client");
        verify(mainPanel, times(3)).add(any());
        verify(incoming).setLineWrap(true);
        verify(incoming).setWrapStyleWord(true);
        verify(incoming).setEditable(false);
        verify(outgoing).setColumns(20);
        verify(sendButton).setText("Send");
        verify(sendButton).addActionListener(listener);
        verify(client).setUpNetworking();
        verify(frame).getContentPane().add(mainPanel, BorderLayout.CENTER);
        verify(frame).setSize(400, 500);
        verify(frame).setVisible(true);
    }
}