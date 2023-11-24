package chat.room;

import javax.swing.JPanel;

public class ChatRoom {
	String title;
	JPanel panel;
	
	public ChatRoom(String title) {
		this.title = title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void addPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
