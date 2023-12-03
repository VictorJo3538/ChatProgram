package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class LoginFailedDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public LoginFailedDialog() {
		JOptionPane.showOptionDialog(
				this,
                "아이디 또는 비밀번호가 잘못되었습니다.",
                "로그인 실패!",
                JOptionPane.YES_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"확인"},
                "확인");
    }
}
