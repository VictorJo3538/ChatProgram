package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MinRoomDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public MinRoomDialog() {
		JOptionPane.showOptionDialog(
				this,
                "최소 하나의 채팅방이 존재해야 합니다.",
                "채팅방 삭제불가!",
                JOptionPane.YES_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new Object[]{"확인"},
                "확인");
    }
}
