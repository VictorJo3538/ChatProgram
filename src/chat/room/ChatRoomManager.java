package chat.room;

import java.awt.CardLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChatRoomManager {
	LinkedList<String> roomlist = new LinkedList<String>();
	String head;
	JPanel textAreaPanel;
	CardLayout cardLayout;
	JLabel titleLabel;
	
	public ChatRoomManager(JPanel textAreaPanel, CardLayout cardLayout) {
		this.textAreaPanel = textAreaPanel;
		this.cardLayout = cardLayout;
	}
	
	public void showRoom(String rnum) {
		textAreaPanel.setVisible(true);
		cardLayout.show(textAreaPanel, rnum);  
		head = rnum;
		if (roomlist.contains(rnum)) {
			roomlist.remove(rnum);
		}
		roomlist.add(rnum);
	}
	
	public void closeRoom(String rnum) {
		if (head != rnum) {
			roomlist.remove(rnum);
			return;
		}
		showPreviousRoom(rnum);
		roomlist.remove(rnum);
	}
	
	private void showPreviousRoom(String rnum) {
		int index = roomlist.indexOf(rnum);
		// 화면 하나남은 경우
		if(roomlist.size() == 1) {
			textAreaPanel.setVisible(false);
			
			return;
		}
		// 첫번째 요소를 없애는 경우 가장 마지막 페이지 보이기
		if (index == 0) {
			head = roomlist.getLast();
			cardLayout.show(textAreaPanel, head);
			return;
		}
		// 아닌 경우에는 이전 페이지 보이기
		head = roomlist.get(index-1);
		cardLayout.show(textAreaPanel, head);
	}
	
	public void getTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}
	
	public void setTitle(JButton button) {
		titleLabel.setText(button.getText());
	}
}
