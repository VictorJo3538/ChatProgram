package chat.dialog;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
public class ChatRoomTitleDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	String userInput;
	
	public ChatRoomTitleDialog(String baseTitle) {
		String userInput = (String) JOptionPane.showInputDialog(
	            this,  // this는 클래스의 인스턴스인 경우 사용 가능, 그렇지 않은 경우 null
	            "여기에 새 채팅방 이름을 입력하세요",  // 다이얼로그에 표시될 메시지 또는 컴포넌트
	            "채팅방 이름 입력",  // 다이얼로그의 제목
	            JOptionPane.PLAIN_MESSAGE,  // 메시지의 타입
	            null,  // 아이콘, null인 경우 아이콘이 표시되지 않음
	            null,  // 선택 가능한 값들을 나타내는 문자열 배열, null로 지정하면 일반적인 텍스트 입력 다이얼로그가 됨
	            baseTitle// 초기 선택값
	            );
		
        // 사용자가 "확인" 버튼을 누르면 입력값이, "취소" 버튼을 누르면 null이 반환됩니다.
        if (userInput != null) {
        	this.userInput = userInput;
        } else {
            // 취소
        }
	}
	
	public String getUserInput() {
		return userInput;
	}
}
