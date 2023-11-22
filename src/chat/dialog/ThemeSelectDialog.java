package chat.dialog;

import javax.swing.*;

import chat.frame.FrameManager;
import chat.theme.ThemeManager;

public class ThemeSelectDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ThemeSelectDialog(LookAndFeel theme) {
        
        int result = JOptionPane.showOptionDialog(
                this,
                "이 테마를 선택 하시겠습니까?",
                "로그아웃 확인",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"예", "아니오"},
                "아니오");

        if (result == JOptionPane.YES_OPTION) {
        	ThemeManager.switchTheme(theme);
        } else {
            // "아니오" 버튼이나 창을 닫았을 때의 동작
        }
    }
}
