package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogManager extends JDialog {
	private static final long serialVersionUID = 1L;

	public static void showLogoutDialog() {
		new LogoutDialog();
	}
	
	public static void showThemeSelectDialog(String theme) {
		new ThemeSelectDialog(theme);
	}
}
