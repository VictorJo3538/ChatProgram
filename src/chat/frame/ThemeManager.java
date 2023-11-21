package chat.frame;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ThemeManager {
	public static String themeFlatLightLaf = "com.formdev.flatlaf.FlatLightLaf";
    public static String themeFlatDarkLaf = "com.formdev.flatlaf.FlatDarkLaf";
    
    public static String themeFlatMacLightLaf = "com.formdev.flatlaf.themes.FlatMacLightLaf";
    public static String themeFlatMacDarkLaf = "com.formdev.flatlaf.themes.FlatMacDarkLaf";
    
    public static String themeFlatDarculaLaf = "com.formdev.flatlaf.FlatDarculaLaf";
    
    public static String themeFlatIntelliJLaf = "com.formdev.flatlaf.FlatIntelliJLaf";
    
    public static void switchTheme(String theme) {
        try {
            // 원하는 테마에 맞게 수정
            UIManager.setLookAndFeel(theme);
            SwingUtilities.updateComponentTreeUI(FrameManager.getChatRoomFrame());  // 채팅방 테마 변경
            SwingUtilities.updateComponentTreeUI(FrameManager.getLoginFrame());  // 로그인 테마 변경
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static LookAndFeel getCurrentTheme() {
    	return UIManager.getLookAndFeel();
    }
}
