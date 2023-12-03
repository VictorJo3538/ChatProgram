package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MaxRoomDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public MaxRoomDialog() {
		JOptionPane.showOptionDialog(
				this,
                "채팅방을 더 생성할 수 없습니다.",
                "채팅방 최대!",
                JOptionPane.YES_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"확인"},
                "확인");
    }
}
