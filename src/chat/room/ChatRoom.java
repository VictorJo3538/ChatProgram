package chat.room;

import javax.swing.*;

public class ChatRoom {
    private JButton openBtn;
    private JButton closeBtn;
    private JPanel btnPanel;
    private JTextPane textPane;

    public ChatRoom(JButton openBtn, JButton closeBtn, JTextPane r0TextPane, JPanel btnPanel) {
        this.openBtn = openBtn;
        this.closeBtn = closeBtn;
        this.textPane = r0TextPane;
        this.btnPanel = btnPanel;
    }
    
    public JButton getOpenBtn() {
        return openBtn;
    }

    public JButton getCloseBtn() {
        return closeBtn;
    }

    public JTextPane getTextPane() {
        return textPane;
    }
    
    public JPanel getBtnPanel() {
    	return btnPanel;
    }
    
}

