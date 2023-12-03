package chat.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

import chat.room.ChatRoomPanel;

public class ChatRoomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// 스크린 사이즈 가져와서 프레임이 중앙으로 오게 설정
	int frameWidth = 1010, frameHeight = 600; // 기본 프레임 크기 설정
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int x = (screenSize.width - frameWidth) / 2;
	int y = (screenSize.height - frameHeight) / 2;
			
	public ChatRoomFrame() {
		setTitle("고양이뱃살(Go!Bat) - 채팅화면");
		Image icon = Toolkit.getDefaultToolkit().getImage("고뱃 아이콘.png");
		setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setLocation(x, y);
		setResizable(false);  // 창변경금지
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout()); // BorderLayout으로 변경
		
		JPanel chatRoomPanel = new ChatRoomPanel();
		contentPane.add(chatRoomPanel);
		
		setContentPane(contentPane);	
		
		// 최대 화면크기 설정
		Timer timer = new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setResizable(true);
				((Timer) e.getSource()).stop();
			}
		});
		
		SwingUtilities.invokeLater(() -> {
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int maxWidth = frameWidth;
                    int maxHeight = frameHeight;

                    if (getWidth() > maxWidth || getHeight() > maxHeight) {
                    	setSize(maxWidth, maxHeight);
                        setResizable(false);
                        timer.restart();
                    }
                }
            });
        });
	}
}
