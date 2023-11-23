package chat.room;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Color;

public class ChatRoomPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ChatRoomPanel() {
		setBounds(0, 0, 1000, 560);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane roomSelectPane = new JScrollPane();
		roomSelectPane.setPreferredSize(new Dimension(300, 520));
		add(roomSelectPane, BorderLayout.WEST);
		
		JScrollPane roomPane = new JScrollPane();
		roomPane.setPreferredSize(new Dimension(500, 520));
		add(roomPane, BorderLayout.CENTER);
		
		JPanel songSelectPanel = new JPanel();
		songSelectPanel.setPreferredSize(new Dimension(200, 520));
		add(songSelectPanel, BorderLayout.EAST);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(1000, 40));
		add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel menuLeftPanel = new JPanel();

		menuPanel.add(menuLeftPanel, BorderLayout.WEST);
		menuLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuLeftPanel.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		JButton makeRoomButton = new JButton("채팅방 생성");
		makeRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(makeRoomButton);
		
		JButton deleteRoomButton = new JButton("채팅방 삭제");
		deleteRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(deleteRoomButton);
		
		JPanel menuCenterPanel = new JPanel();
		menuPanel.add(menuCenterPanel, BorderLayout.CENTER);
		menuCenterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton memberButton = new JButton("대화상대");
		memberButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuCenterPanel.add(memberButton);
		
		JPanel menuRightPanel = new JPanel();
		menuPanel.add(menuRightPanel, BorderLayout.EAST);
		menuRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuRightPanel.setBorder(new EmptyBorder(0, 0, 0, 10));
		
		JButton profileButton = new JButton("프로필");
		profileButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuRightPanel.add(profileButton);
		
		JButton logoutButton = new JButton("로그아웃");
		logoutButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuRightPanel.add(logoutButton);
	}

}
