package chat.room;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ChatRoomManager {
	LinkedList<String> roomlist = new LinkedList<String>();
	ArrayList<JButton> roomButtonList = new ArrayList<JButton>();
	String head;
	JPanel textAreaPanel;
	CardLayout cardLayout;
	JButton titleButton;  // 중앙 상단 방제 버튼
	
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
			titleButton.setText("채팅방 클릭하여 시작");
			return;
		}
		// 첫번째 요소를 없애는 경우 가장 마지막 페이지 보이기
		if (index == 0) {
			head = roomlist.getLast();
			cardLayout.show(textAreaPanel, head);
			updateTitleButton();
			return;
		}
		// 아닌 경우에는 이전 페이지 보이기
		head = roomlist.get(index-1);
		cardLayout.show(textAreaPanel, head);
		updateTitleButton();
	}
	
	public void setTitleButton(JButton titleButton) {
		this.titleButton = titleButton;
	}
	
	public JButton getTitleButton() {
		return titleButton;
	}
	
	private void updateTitleButton() {
		// head를 기준으로 타이틀 변경
		titleButton.setText(roomButtonList.get(Character.getNumericValue(head.charAt(1) - 1)).getText());
	}
	
	public void addRoomButtonlist(JButton roomButton) {
		roomButtonList.add(roomButton);
	}
	
	public void setRoomTitle(String title) {
		int index = Character.getNumericValue(head.charAt(1)) - 1;  // "rn"의 숫자 n 가져오기
		roomButtonList.get(index).setText(title);
		titleButton.setText(title);
	}
	
	public int getActivatedRooms() {
		return roomlist.size();
	}
}
