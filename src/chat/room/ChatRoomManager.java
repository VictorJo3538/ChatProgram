package chat.room;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;

import chat.dialog.DialogManager;
import chat.server.Client;
import chat.server.Client.Message;
import chat.server.Client.RoomTitle;
import chat.user.User;

public class ChatRoomManager {
	private ArrayList<ChatRoom> chatRoomList = new ArrayList<ChatRoom>();
	private LinkedList<Integer> activationList = new LinkedList<Integer>();
	ArrayList<JScrollPane> scrollPaneList = new ArrayList<JScrollPane>();
	
	public ServerInterface server;
	public ChatRoomLimiter limiter = new ChatRoomLimiter();
	
	private JButton titleButton;
	private JPanel textAreaPanel;
	private CardLayout cardLayout;
	private JTextField textField;
	private int topIndex = -1;
	
	public ChatRoomManager(JButton titleButton, JPanel textAreaPanel, CardLayout cardLayout, JTextField textField) {
		this.titleButton = titleButton;
		this.textAreaPanel = textAreaPanel;
		this.cardLayout = cardLayout;
		this.textField = textField;
		this.server = new ServerInterface();
	}
	
	public JButton getTitleButton() {
		return titleButton;
	}
	
	public void updateTitleButtons(String title) {
		chatRoomList.get(topIndex).getOpenBtn().setText(title);
		titleButton.setText(title);
	}
	
	public void updateTitleButtons(String title, int roomNum) {
		chatRoomList.get(roomNum).getOpenBtn().setText(title);
	}
	
	public void addScrollPane(JScrollPane scrollPane) {
		scrollPaneList.add(scrollPane);
	}
	
	// 채팅방 객체 초기화
	public void addChatRoom(ChatRoom chatRoom) {
		chatRoomList.add(chatRoom);
	}
	
	public class ChatRoomLimiter {
		private int activation = 0;
		
		// 채팅방 추가버튼에 사용
		public void showRoomPanel() {
			activation++;
			if (activation == 5) {
				DialogManager.showMaxRoomDialog();
				activation--;
				return;
			}
			ChatRoom chatRoom = chatRoomList.get(activation);
			chatRoom.getBtnPanel().setVisible(true);
		}
		
		// 채팅방 삭제버튼에 사용
		public void hideRoomPanel() {
			if (activation == 0) {
				DialogManager.showMinRoomDialog();
				return;
			}
			ChatRoom chatRoom = chatRoomList.get(activation);
			chatRoom.getBtnPanel().setVisible(false);
			activation--;
		}
	}
	
	
	// 컴포넌트별 액션 추가
	public void initListener() {
		for (int i = 0; i < 5; i++) {
			chatRoomList.get(i).getOpenBtn().addActionListener(new OpenButtonListener(i));  // 방 클릭버튼
			chatRoomList.get(i).getCloseBtn().addActionListener(new CloseButtonListener(i));  // 방 접기버튼
		}
		// 중앙 상단 타이틀 버튼
		titleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newTitle = DialogManager.showChatRoomTitleDialog(titleButton.getText());
				RoomTitle.sendRequest(newTitle, topIndex); // 서버에 방제변경 요청 보내기
			}
		});
	}
	
	// 채팅창 오픈버튼 리스너
	private class OpenButtonListener implements ActionListener {
		private String[] textAreaIndex = {"0", "1", "2", "3", "4"};
		int index;
		
		public OpenButtonListener(int index) {
			this.index = index;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			titleButton.setEnabled(true);  // 타이틀버튼 활성화
			textAreaPanel.setVisible(true);
			cardLayout.show(textAreaPanel, textAreaIndex[index]);
			String title = chatRoomList.get(index).getOpenBtn().getText();
			titleButton.setText(title);
			chatRoomList.get(index).getCloseBtn().setVisible(true);
			activationList.add(index);  // 활성화 리스트에 추가
			topIndex = index;  // 최상단 변수에 추가
		}
	}
	
	// 채팅창 클로우즈 버튼 리스너
	private class CloseButtonListener implements ActionListener {
		PageSelector pgs;
		int index;
		
		public CloseButtonListener(int index) {
			this.index = index;
			pgs = new PageSelector(this.index);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pgs.closeRoom();
		}
	}
	
	private class PageSelector {
		int rnum;
		
		public PageSelector(int rnum) {
			this.rnum = rnum;
		}
		
		public void closeRoom() {
			if (topIndex == rnum) {
				showPreviousRoom(rnum);
			} 
			activationList.remove(Integer.valueOf(rnum));
			chatRoomList.get(rnum).getCloseBtn().setVisible(false);
		}
		
		private void showPreviousRoom(int rnum) {
			int index = activationList.indexOf(rnum);
			// 화면 하나남은 경우
			if(activationList.size() == 1) {
				textAreaPanel.setVisible(false);
				titleButton.setText("채팅방 클릭하여 시작");
				titleButton.setEnabled(false);
				topIndex = -1;
				return;
			}
			// 첫번째 요소를 없애는 경우 가장 마지막 페이지 보이기
			if (index == 0) {
				topIndex = activationList.getLast();

				return;
			} else {
				// 아닌 경우에는 이전 페이지 보이기
				topIndex = activationList.get(index - 1);
			}
			updateTitleButtons(chatRoomList.get(topIndex).getOpenBtn().getText());
			cardLayout.show(textAreaPanel, Integer.toString(topIndex));  // 화면 보이기
		}
	}
	
	// 중앙 하단 텍스트필드에서 입력한 값 -> 서버, 서버 -> 중앙 텍스트에리어로 정보 입출력
	public class ServerInterface {
		
		private ServerInterface() {			
			textField.addActionListener(new ActionListener() {
				@Override  // 텍스트 필드에서 Enter 키를 눌렀을 때 실행할 로직
				public void actionPerformed(ActionEvent e) {
					String userName = Client.userName;
					
					// 아무 채팅방도 안보고 있으면 채팅 못치게 막기
					if (topIndex == -1) {
						return;
					}
					//

					String text = formatText(textField.getText(), userName);  // 텍스트 필드에서 텍스트 가져와 포매팅
					System.out.print("(보냄)"+text);
					
					// 서버에 채팅 보내기
					Message.sendRequest(topIndex, text);
					
					// 필드 초기화
					textField.setText("");
				}
			});
		}
		
		// roomNum: 0~4 까지의 채팅방 인덱스, text: 입력할 텍스트
		public void updateChatRoom(int roomNum, String text) {
		    JTextPane textPane = chatRoomList.get(roomNum).getTextPane();  // 인덱스가 'index'인 채팅방의 텍스트판 가져오기
		    appendToTextPane(textPane, text);  // 텍스트판에 텍스트 보내기
		    System.out.print("(받음)" + text);
		    
			// 스크롤을 최하단으로 이동
		    JScrollPane scrollPane = scrollPaneList.get(topIndex);
			JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
			verticalScrollBar.setValue(verticalScrollBar.getMaximum());
		}

		private String formatText(String text, String userName) {
			// 현재 시각 가져오기
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	        String currTime = currentDateTime.format(formatter);
			return currTime+":["+userName+"]>> " + text + "\n";
		}
		
		private void appendToTextPane(JTextPane textPane, String text) {
			StyledDocument doc = (StyledDocument) textPane.getDocument();

			try {
				// 추가할 텍스트를 현재 문서에 삽입
				doc.insertString(doc.getLength(), text, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
