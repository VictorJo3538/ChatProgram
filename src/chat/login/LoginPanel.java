package chat.login;

import javax.swing.*;

import chat.frame.FrameManager;
import chat.frame.LogInFrame;

import java.awt.*;
import java.awt.event.*;


public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField idField;
	private JPasswordField passwordField;
	

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBounds(0, 0, 728, 560);
		setLayout(null);
		
		JLabel iconLabel = new JLabel("고양이 이미지");
		iconLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/Img/loginCat2.png")));
		iconLabel.setBounds(0, 0, 728, 287);
		add(iconLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 287, 728, 273);
		add(panel);
		panel.setLayout(null);
		
		idField = new JTextField();
		idField.setFont(new Font("Arial", Font.PLAIN, 20));
		idField.setBounds(173, 65, 262, 46);
		panel.add(idField);
		idField.setColumns(10);
		
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		idLabel.setBounds(173, 31, 75, 24);
		panel.add(idLabel);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		passwordLabel.setBounds(173, 115, 104, 24);
		panel.add(passwordLabel);
		
		JLabel registerLabel = new JLabel("Go!Bat의 회원이 아니라면?");
		registerLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		registerLabel.setBounds(14, 218, 263, 24);
		panel.add(registerLabel);
		
		JButton registerButton = new JButton("회원가입Go!");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((LogInFrame) FrameManager.getLoginFrame()).showRegisterPanel();
			}
		});
		registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		registerButton.setBounds(12, 240, 104, 23);
		panel.add(registerButton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 20));
		passwordField.setBounds(173, 144, 262, 46);
		panel.add(passwordField);
		
		JLabel wrongInputWarningLabel = new JLabel("아이디 또는 비밀번호가 일치하지 않습니다!");
		wrongInputWarningLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		wrongInputWarningLabel.setForeground(new Color(255, 0, 0));
		wrongInputWarningLabel.setBounds(183, 200, 246, 15);
		wrongInputWarningLabel.setVisible(false);
		panel.add(wrongInputWarningLabel);
		
		JLabel emptyInputWarningLabel = new JLabel("아이디 또는 비밀번호가 공란일 수 없습니다!");
		emptyInputWarningLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		emptyInputWarningLabel.setForeground(new Color(255, 0, 0));
		emptyInputWarningLabel.setBounds(183, 200, 246, 15);
		emptyInputWarningLabel.setVisible(false);
		panel.add(emptyInputWarningLabel);
		
		JButton loginButton = new JButton("로그인Go!");
		loginButton.setForeground(Color.BLACK);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wrongInputWarningLabel.setVisible(false);
				emptyInputWarningLabel.setVisible(false);
				
				String id; char[] password;
				
				id = idField.getText();
				password = passwordField.getPassword();
				
				if(id.length() == 0 || password.length == 0) {
					emptyInputWarningLabel.setVisible(true);
					return;
				}
				if(!id.equals(String.valueOf(password))) {
					// 아이디 비밀번호가 정확하지 않을때 로직 구현(현재 임시상태)
					wrongInputWarningLabel.setVisible(true);
					return;
				}
				
				// 제대로 로그인 했을 때 
				FrameManager.getLoginFrame().setVisible(false);
				FrameManager.getChatRoomFrame().setVisible(true);
			}
		});
		loginButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		loginButton.setBounds(447, 65, 130, 125);
		panel.add(loginButton);
	}
}
