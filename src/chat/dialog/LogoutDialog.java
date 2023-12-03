package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import chat.frame.FrameManager;

public class LogoutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public LogoutDialog() {
        
        int result = JOptionPane.showOptionDialog(
                this,
                "정말 로그아웃 하시겠습니까?",
                "로그아웃 확인",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"예", "아니오"},
                "아니오");

        if (result == JOptionPane.YES_OPTION) {
            // "예" 버튼을 눌렀을 때의 동작
            FrameManager.getChatRoomFrame().setVisible(false);
            FrameManager.getLoginFrame().setVisible(true);
            
        } else {
            // "아니오" 버튼이나 창을 닫았을 때의 동작
        }
    }
}
