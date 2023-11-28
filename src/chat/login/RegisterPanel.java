package chat.login;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import chat.frame.FrameManager;
import chat.frame.LogInFrame;
import chat.user.ChatClient;

public class RegisterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField idField;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmField;

	/**
	 * Create the panel.
	 */
	public RegisterPanel() {
		setLayout(null);
		setBounds(0, 0, 728, 560);

		// 패널 생성
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 728, 560);
		add(panel);

		// 고양이 이미지 생성
		JLabel logoPanel = new JLabel("고양이이미지");
		logoPanel.setBounds(0, 0, 728, 287);
		logoPanel.setIcon(new ImageIcon(RegisterPanel.class.getResource("/Img/loginCat2.png")));
		panel.add(logoPanel);
		
		JLabel idLabel = new JLabel("아이디 입력");
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		idLabel.setBounds(406, 318, 116, 24);
		panel.add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Arial", Font.PLAIN, 20));
		idField.setBounds(406, 352, 262, 46);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("비밀번호 입력");
		passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordLabel.setBounds(57, 408, 162, 24);
		panel.add(passwordLabel);
		
		JLabel passwordConfirmLabel = new JLabel("비밀번호 확인");
		passwordConfirmLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordConfirmLabel.setBounds(406, 408, 162, 24);
		panel.add(passwordConfirmLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(57, 351, 262, 46);
		panel.add(nameField);
		
		JLabel nameLabel = new JLabel("사용자명");
		nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		nameLabel.setBounds(57, 318, 116, 24);
		panel.add(nameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(57, 442, 262, 46);
		panel.add(passwordField);
		
		passwordConfirmField = new JPasswordField();
		passwordConfirmField.setBounds(406, 442, 262, 46);
		panel.add(passwordConfirmField);
		
		JLabel passwordMismatchWarningnLabel = new JLabel("비밀번호가 일치하지 않습니다!");
		passwordMismatchWarningnLabel.setForeground(new Color(255, 0, 0));
		passwordMismatchWarningnLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		passwordMismatchWarningnLabel.setBounds(487, 497, 181, 15);
		passwordMismatchWarningnLabel.setVisible(false);
		panel.add(passwordMismatchWarningnLabel);
		
		JLabel emptyWarningLabel = new JLabel("입력 칸을 모두 채워주세요");
		emptyWarningLabel.setForeground(new Color(255, 0, 0));
		emptyWarningLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		emptyWarningLabel.setBounds(487, 497, 181, 15);
		emptyWarningLabel.setVisible(false);
		panel.add(emptyWarningLabel);
		
		JButton confirmButton = new JButton("완료");
		confirmButton.setBounds(457, 512, 100, 38);
		panel.add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 경고문구 초기화
				emptyWarningLabel.setVisible(false);
				passwordMismatchWarningnLabel.setVisible(false);
				
				String name, id, passwordConfirm, password;
				
				name = nameField.getText();
				id = idField.getText();
				password = new String(passwordField.getPassword());
				passwordConfirm = new String(passwordConfirmField.getPassword());
				
				ChatClient cl = new ChatClient();
				// 제대로 입력 안하면 함수 종료시키기
				if(name.length() == 0 || id.length() == 0 || password.length() == 0 || passwordConfirm.length() == 0) {
					emptyWarningLabel.setVisible(true);
					return;
				}
				else if (!(password.equals(passwordConfirm) && password.length() > 0)) {
					passwordMismatchWarningnLabel.setVisible(true);
					return;
				}
				else {
//					cl.send();
				}
			}
		});
		confirmButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		
		JButton cancelButton = new JButton("취소");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((LogInFrame) FrameManager.getLoginFrame()).showLoginPanel();
			}
		});
		cancelButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cancelButton.setBounds(569, 512, 100, 38);
		panel.add(cancelButton);
		
	}
}
