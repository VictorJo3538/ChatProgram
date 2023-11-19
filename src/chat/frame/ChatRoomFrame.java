package chat.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chat.room.ChatRoomPanel;

public class ChatRoomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public ChatRoomFrame() {
		// 스크린 사이즈 가져와서 프레임이 중앙으로 오게 설정
		int frameWidth = 728, frameHeight = 600; // 기본 프레임 크기 설정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frameWidth) / 2;
		int y = (screenSize.height - frameHeight) / 2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setLocation(x, y);
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		
		JPanel chatRoomPanel = new ChatRoomPanel();
		contentPane.add(chatRoomPanel);
	}
}