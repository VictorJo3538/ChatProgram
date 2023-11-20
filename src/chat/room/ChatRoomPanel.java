package chat.room;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;

public class ChatRoomPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ChatRoomPanel() {
		setBounds(0, 0, 1000, 560);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane roomSelectPane = new JScrollPane();
		roomSelectPane.setPreferredSize(new Dimension(300, 510));
		add(roomSelectPane, BorderLayout.WEST);
		
		JScrollPane roomPane = new JScrollPane();
		roomPane.setPreferredSize(new Dimension(500, 510));
		add(roomPane, BorderLayout.CENTER);
		
		JPanel songSelectPanel = new JPanel();
		songSelectPanel.setPreferredSize(new Dimension(200, 510));
		add(songSelectPanel, BorderLayout.EAST);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(1000, 50));
		add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.X_AXIS));
	}

}
