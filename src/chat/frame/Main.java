package chat.frame;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;


public class Main {
	// 어플리케이션 실행
	public static void main(String[] args) {
		
		// flatlaf 테마 적용
		try {
			UIManager.setLookAndFeel(new FlatCyanLightIJTheme());
		} catch (Exception e) {
			System.err.println("Failed to initialize LaF");
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameManager.getLoginFrame().setVisible(true);  // 로그인 프레임 보이기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
