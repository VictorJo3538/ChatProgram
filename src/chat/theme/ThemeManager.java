package chat.theme;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import chat.frame.FrameManager;


public class ThemeManager {
	public static Themes themes = new Themes();  // 테마 객체 생성
	
	public static void switchTheme(LookAndFeel theme) {
		if (theme.equals(ThemeManager.getCurrentTheme())) {
			return;
		}	
		
		SwingUtilities.invokeLater(() -> {
			try {
				// 원하는 테마에 맞게 수정 
				UIManager.setLookAndFeel(theme);
				SwingUtilities.updateComponentTreeUI(FrameManager.getChatRoomFrame()); // 채팅방 프레임 테마 변경
				SwingUtilities.updateComponentTreeUI(FrameManager.getLoginFrame()); // 로그인 프레임 테마 변경
				System.out.println(theme);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static LookAndFeel getCurrentTheme() {
		return UIManager.getLookAndFeel();
	}
	
	// 현재 테마의 hasDarkmode 메서드 호출
	public static boolean hasDarkmode(LookAndFeel currentTheme) {
        if (currentTheme.equals(themes.FlatLightLaf)) {
            return true;
        } else if (currentTheme.equals(themes.FlatMacLightLaf)) {
            return true;
        } else if (currentTheme.equals(themes.FlatArcIJTheme)) {
        	return true;
        } else if (currentTheme.equals(themes.FlatArcOrangeIJTheme)) {
        	return true;
        }
        	
        return false;
    } 
	
	public static void changeMode(LookAndFeel theme) {

	    if (theme.equals(themes.FlatLightLaf)) {
	        switchTheme(themes.FlatDarkLaf);
	    } else if (theme.equals(themes.FlatDarkLaf)) {
	        switchTheme(themes.FlatLightLaf);
	        
	    } else if (theme.equals(themes.FlatMacLightLaf)) {
	        switchTheme(themes.FlatMacDarkLaf);
	    } else if (theme.equals(themes.FlatMacDarkLaf)) {
	        switchTheme(themes.FlatMacLightLaf);
	        
	    } else if (theme.equals(themes.FlatArcIJTheme)) {
	        switchTheme(themes.FlatArcDarkIJTheme);
	    } else if (theme.equals(themes.FlatArcDarkIJTheme)) {
	        switchTheme(themes.FlatArcIJTheme);
	        
	    } else if (theme.equals(themes.FlatArcOrangeIJTheme)) {
	        switchTheme(themes.FlatArcDarkOrangeIJTheme);
	    } else if (theme.equals(themes.FlatArcDarkOrangeIJTheme)) {
	        switchTheme(themes.FlatArcOrangeIJTheme);
	    } 
	    
	}

	
}
