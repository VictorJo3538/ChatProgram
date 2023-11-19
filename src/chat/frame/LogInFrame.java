package chat.frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import chat.login.LoginPanel;
import chat.login.RegisterPanel;

import java.awt.CardLayout;

public class LogInFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	// CardLayout을 사용할 패널 생성
    CardLayout cardLayout = new CardLayout();
    JPanel cards = new JPanel(cardLayout);
    
    private static LogInFrame staticFrame;  // 프레임을 담을 스태틱 변수

	// 프레임 제작
	public LogInFrame() {
		staticFrame = this;
		
		// 스크린 사이즈 가져와서 프레임이 중앙으로 오게 설정
		int frameWidth = 728, frameHeight = 600; // 기본 프레임 크기 설정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frameWidth) / 2;
		int y = (screenSize.height - frameHeight) / 2;
				
		setTitle("고양이뱃살(Go!Bat)");
		setResizable(false);  // 창변경금지
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);
		setLocation(x, y);
		
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(frameWidth, frameHeight);

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel loginPanel = new LoginPanel();
		JPanel RegisterPanel = new RegisterPanel();
		
		cards.add("LoginPanel", loginPanel);  // 로그인 패널 추가
		cards.add("RegisterPanel", RegisterPanel);  // 회원가입 패널 추가
		
		contentPane.add(cards);
		
	}
	
	public static LogInFrame getObject() {
		return staticFrame;
	}
	
	public void showRegisterPanel( ) {
		cardLayout.show(cards, "RegisterPanel");
	}
	
	public void showLoginPanel() {
		cardLayout.show(cards, "LoginPanel");
	}

}
