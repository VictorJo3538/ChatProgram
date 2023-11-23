package chat.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chat.room.ChatRoomPanel;

public class ChatRoomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// 스크린 사이즈 가져와서 프레임이 중앙으로 오게 설정
	int frameWidth = 1000, frameHeight = 600; // 기본 프레임 크기 설정
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screenSize.width - frameWidth) / 2;
	int y = (screenSize.height - frameHeight) / 2;
			
	public ChatRoomFrame() {
		setTitle("고양이뱃살(Go!Bat) - 채팅화면");
		Image icon = Toolkit.getDefaultToolkit().getImage("/resources/img/고뱃 프레임 아이콘.png");
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setLocation(x, y);
		setResizable(true);
		
		contentPane = new JPanel();

		setContentPane(contentPane);
		
		JPanel chatRoomPanel = new ChatRoomPanel();
		contentPane.add(chatRoomPanel);
	}
}
