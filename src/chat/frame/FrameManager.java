package chat.frame;

import javax.swing.*;

public class FrameManager {
	static JFrame chatRoom;
	static JFrame loginFrame;
	static {
		try {
			loginFrame = new LogInFrame();
			chatRoom = new ChatRoomFrame();
		} catch (Exception e) {
			System.out.println("스태틱 예외발생");
			System.out.println(e.getStackTrace());
		}
	}
    
    public static JFrame getChatRoomFrame() {
    	return chatRoom;
    }
    
    public static JFrame getLoginFrame() {
    	return loginFrame;
    }
}
