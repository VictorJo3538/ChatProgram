package chat.frame;

import java.util.*;

import javax.swing.*;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;

public class FrameManager {
	static JFrame chatRoom = new ChatRoomFrame();
	static JFrame loginFrame = new LogInFrame();
    
    public static JFrame getChatRoomFrame() {
    	return chatRoom;
    }
    
    public static JFrame getLoginFrame() {
    	return loginFrame;
    }
}
