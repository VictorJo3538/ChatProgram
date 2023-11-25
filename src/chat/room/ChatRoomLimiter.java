package chat.room;

import javax.swing.JPanel;

public class ChatRoomLimiter {
	int index = 0, activation = 1;  // 하나는 무조건 있어야함
	ChatRoom[] rooms;
	
	public ChatRoomLimiter() {
		rooms = new ChatRoom[5];
	}
	
	public void addRoom(String title, JPanel Panel) {
		rooms[index] = new ChatRoom(title);
		rooms[index].addPanel(Panel);
		index++;
	}
	
	public ChatRoom getChatRoom(int num) {
		return rooms[num-1];
	}
	
	public void addActivation() {
		if (activation == 5)
			return;
		activation++;
	}
	
	public void reduceActivation() {
		if (activation == 1)
			return;
		activation--;
	}
	
	public int getActivation() {
		return activation;
	}
}
