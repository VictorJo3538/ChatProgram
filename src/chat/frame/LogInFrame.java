package chat.frame;

import java.awt.*;

import javax.swing.*;

import chat.login.LoginPanel;
import chat.login.RegisterPanel;

public class LogInFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	// CardLayout을 사용할 패널 생성
    CardLayout cards = new CardLayout();
    JPanel mainPanel = new JPanel(cards);
    
	// 프레임 제작
	public LogInFrame() {
		// 스크린 사이즈 가져와서 프레임이 중앙으로 오게 설정
		int frameWidth = 730, frameHeight = 600; // 기본 프레임 크기 설정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frameWidth) / 2;
		int y = (screenSize.height - frameHeight) / 2;
				
		setTitle("고양이뱃살(Go!Bat) - 로그인 화면");
		Image icon = Toolkit.getDefaultToolkit().getImage("고뱃 아이콘.png");
        setIconImage(icon);
		setResizable(false);  // 창변경금지
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setLocation(x, y);
		
		contentPane = new JPanel();
		contentPane.setSize(frameWidth, frameHeight);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new LoginPanel();
		JPanel RegisterPanel = new RegisterPanel();
		
		mainPanel.add("LoginPanel", loginPanel);  // 로그인 패널 추가
		mainPanel.add("RegisterPanel", RegisterPanel);  // 회원가입 패널 추가
		
		contentPane.add(mainPanel);
		
	}
	
	public void showRegisterPanel( ) {
		cards.show(mainPanel, "RegisterPanel");
	}
	
	public void showLoginPanel() {
		cards.show(mainPanel, "LoginPanel");
	}

}
