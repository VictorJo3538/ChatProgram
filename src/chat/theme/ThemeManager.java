package chat.theme;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import chat.frame.FrameManager;


public class ThemeManager {
	public static Themes themes = new Themes();  // 테마 객체 생성
	
	public static void switchTheme(LookAndFeel theme) {	
		try {
			// 원하는 테마에 맞게 수정 
			UIManager.setLookAndFeel(theme);
			SwingUtilities.updateComponentTreeUI(FrameManager.getChatRoomFrame()); // 채팅방 프레임 테마 변경
			SwingUtilities.updateComponentTreeUI(FrameManager.getLoginFrame()); // 로그인 프레임 테마 변경123
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LookAndFeel getCurrentTheme() {
		return UIManager.getLookAndFeel();
	}
	
	// 현재 테마의 hasDarkmode 메서드 호출
	public static boolean hasDarkmode(LookAndFeel currentTheme) {
        if (currentTheme instanceof FlatLightLaf) {
            return true;
        } else if (currentTheme instanceof FlatLightLaf) {
            return true;
        } else if (currentTheme instanceof FlatArcIJTheme) {
        	return true;
        } else if (currentTheme instanceof FlatArcOrangeIJTheme) {
        	return true;
        }
        	
        return false;
    } 
	
}
