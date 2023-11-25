package chat.room;

import javax.swing.*;
import javax.swing.border.*;

import chat.dialog.DialogManager;
import chat.frame.FrameManager;
import chat.theme.ThemeManager;
import chat.theme.Themes;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatRoomPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ChatRoomPanel() {
		setBounds(0, 0, 1000, 560);
		setLayout(null);
		
		JPanel leftMenuPanel = new JPanel();
		leftMenuPanel.setBounds(0, 60, 300, 500);
		leftMenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
		add(leftMenuPanel);
		leftMenuPanel.setLayout(null);
		
		// 중앙패널
		JPanel centerPanel = new JPanel();
		centerPanel.setToolTipText("공백");
		centerPanel.setBounds(300, 60, 500, 500);
		centerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
		add(centerPanel);
		centerPanel.setLayout(null);

		// 중앙 하단 텍스트필드
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setBounds(0, 450, 500, 50);
		centerPanel.add(textFieldPanel);
		textFieldPanel.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBounds(0, 0, 450, 50);
		textFieldPanel.add(textField);
		textField.setColumns(10);
		
		JButton goButton = new JButton("");
		goButton.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/고뱃 입장 아이콘.png")));
		goButton.setBackground(Color.LIGHT_GRAY);
		goButton.setBounds(450, 0, 50, 50);
		textFieldPanel.add(goButton);
		
		// 채팅 화면 구현
		CardLayout cardLayout = new CardLayout(); // 카드 레이아웃 생성
		JPanel textAreaPanel = new JPanel(cardLayout);
		textAreaPanel.setBounds(0, 0, 500, 450);
		textAreaPanel.setVisible(false);
		centerPanel.add(textAreaPanel);
//		textAreaPanel.setCaretPosition(textArea.getDocument().getLength());  // 자동 스크롤 함수구현

		// 채팅 텍스트 에리아 생성
		JTextArea r0TextArea = new JTextArea();
		JScrollPane r0ScrollPane = new JScrollPane(r0TextArea);
		r0ScrollPane.setSize(500, 450);
		textAreaPanel.add("r1", r0ScrollPane);

		JTextArea r1TextArea = new JTextArea();
		JScrollPane r1ScrollPane = new JScrollPane(r1TextArea);
		r1ScrollPane.setSize(500, 450);
		textAreaPanel.add("r2", r1ScrollPane);

		JTextArea r2TextArea = new JTextArea();
		JScrollPane r2ScrollPane = new JScrollPane(r2TextArea);
		r2ScrollPane.setSize(500, 450);
		textAreaPanel.add("r3", r2ScrollPane);

		JTextArea r3TextArea = new JTextArea();
		JScrollPane r3ScrollPane = new JScrollPane(r3TextArea);
		r3ScrollPane.setSize(500, 450);
		textAreaPanel.add("r4", r3ScrollPane);

		JTextArea r4TextArea = new JTextArea();
		JScrollPane r4ScrollPane = new JScrollPane(r4TextArea);
		r4ScrollPane.setSize(500, 450);
		textAreaPanel.add("r5", r4ScrollPane);
		
		JLabel centerIconLabel = new JLabel("");
		centerIconLabel.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/센터 아이콘.png")));  // 중앙 아이콘 설정
		centerIconLabel.setBounds(0, 0, 500, 500);
		centerPanel.add(centerIconLabel);
		
		// 채팅방 객체 초기화
		ChatRoomManager chatRooms = new ChatRoomManager();
		
		// 버튼 로직 클래스
		class ChatRoomButton {
			public static void pressButton(JPanel textAreaPanel, String rnum, CardLayout cardLayout) {
				textAreaPanel.setVisible(true);
				cardLayout.show(textAreaPanel, rnum);
			}
		}
		
		// 채팅방 1
		JPanel roomSelctPanel0 = new JPanel();
		roomSelctPanel0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel0.setBounds(0, 0, 300, 100);
		leftMenuPanel.add(roomSelctPanel0);
		roomSelctPanel0.setLayout(null);
		
		JButton goButton0 = new JButton("");
		goButton0.setBounds(238, 20, 50, 50);
		goButton0.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/채팅방 숨기기.png")));
		goButton0.setBackground(Color.LIGHT_GRAY);
		roomSelctPanel0.add(goButton0);
		
		JButton roomTitleButton0 = new JButton("채팅방 1");  
		roomTitleButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatRoomButton.pressButton(textAreaPanel, "r1", cardLayout);
			}
		});
		roomTitleButton0.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton0.setBounds(12, 20, 214, 50);
		roomSelctPanel0.add(roomTitleButton0);
		chatRooms.addRoom(roomTitleButton0.getText(), roomSelctPanel0);  // 1번 채팅방 버튼, 이름 가져오기
		
		// 채팅방 2
		JPanel roomSelctPanel1 = new JPanel();
		roomSelctPanel1.setLayout(null);
		roomSelctPanel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel1.setBounds(0, 100, 300, 100);
		roomSelctPanel1.setVisible(false);
		leftMenuPanel.add(roomSelctPanel1);
		
		JButton goButton1 = new JButton("");
		goButton1.setBackground(Color.LIGHT_GRAY);
		goButton1.setBounds(238, 20, 50, 50);
		goButton1.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/채팅방 숨기기.png")));
		roomSelctPanel1.add(goButton1);
		
		JButton roomTitleButton1 = new JButton("채팅방 2");  
		roomTitleButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatRoomButton.pressButton(textAreaPanel, "r2", cardLayout);
			}
		});
		roomTitleButton1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton1.setBounds(12, 20, 214, 50);
		roomSelctPanel1.add(roomTitleButton1);
		chatRooms.addRoom(roomTitleButton1.getText(), roomSelctPanel1);  // 2번 채팅방 버튼, 이름 가져오기
		
		// 채팅방 3
		JPanel roomSelctPanel2 = new JPanel();
		roomSelctPanel2.setLayout(null);
		roomSelctPanel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel2.setBounds(0, 200, 300, 100);
		roomSelctPanel2.setVisible(false);
		leftMenuPanel.add(roomSelctPanel2);
		
		JButton goButton2 = new JButton("");
		goButton2.setBackground(Color.LIGHT_GRAY);
		goButton2.setBounds(238, 20, 50, 50);
		goButton2.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/채팅방 숨기기.png")));
		roomSelctPanel2.add(goButton2);
		
		JButton roomTitleButton2 = new JButton("채팅방 3");  
		roomTitleButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatRoomButton.pressButton(textAreaPanel, "r3", cardLayout);
			}
		});
		roomTitleButton2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton2.setBounds(12, 20, 214, 50);
		roomSelctPanel2.add(roomTitleButton2);
		chatRooms.addRoom(roomTitleButton2.getText(), roomSelctPanel2); // 3번 채팅방 버튼, 이름 가져오기
		
		// 채팅방 4
		JPanel roomSelctPanel3 = new JPanel();
		roomSelctPanel3.setLayout(null);
		roomSelctPanel3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel3.setBounds(0, 300, 300, 100);
		roomSelctPanel3.setVisible(false);
		leftMenuPanel.add(roomSelctPanel3);
		
		JButton goButton3 = new JButton("");
		goButton3.setBackground(Color.LIGHT_GRAY);
		goButton3.setBounds(238, 20, 50, 50);
		goButton3.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/채팅방 숨기기.png")));
		roomSelctPanel3.add(goButton3);
		
		JButton roomTitleButton3 = new JButton("채팅방 4");  // 
		roomTitleButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatRoomButton.pressButton(textAreaPanel, "r4", cardLayout);
			}
		});
		roomTitleButton3.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton3.setBounds(12, 20, 214, 50);
		roomSelctPanel3.add(roomTitleButton3);
		chatRooms.addRoom(roomTitleButton3.getText(), roomSelctPanel3); // 4번 채팅방 버튼, 이름 가져오기
		
		// 채팅방 5
		JPanel roomSelctPanel4 = new JPanel();
		roomSelctPanel4.setLayout(null);
		roomSelctPanel4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel4.setBounds(0, 400, 300, 100);
		roomSelctPanel4.setVisible(false);
		leftMenuPanel.add(roomSelctPanel4);
		
		JButton goButton4 = new JButton("");
		goButton4.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/채팅방 숨기기.png")));
		goButton4.setBackground(Color.LIGHT_GRAY);
		goButton4.setBounds(238, 20, 50, 50);
		roomSelctPanel4.add(goButton4);
		
		JButton roomTitleButton4 = new JButton("채팅방 5");  // 5번 채팅방 이름 가져오기
		roomTitleButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatRoomButton.pressButton(textAreaPanel, "r5", cardLayout);
			}
		});
		roomTitleButton4.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton4.setBounds(12, 20, 214, 50);
		roomSelctPanel4.add(roomTitleButton4);
		chatRooms.addRoom(roomTitleButton4.getText(), roomSelctPanel4);  // 5번 채팅방 버튼, 이름 가져오기
		
		// 왼쪽 패널 아이콘 설정
		JLabel leftIconLabel = new JLabel("");
		leftIconLabel.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/왼쪽 아이콘.png")));
		leftIconLabel.setBounds(0, 0, 300, 500);
		leftMenuPanel.add(leftIconLabel);
		
		// 우측 메뉴 패널
		JPanel rightMenuPanel = new JPanel();
		rightMenuPanel.setBounds(800, 60, 200, 500);
		rightMenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
		add(rightMenuPanel);
		
		JLabel rightIconLabel = new JLabel("");
		rightIconLabel.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/길쭉고양이.png")));
		rightMenuPanel.add(rightIconLabel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 20, 1000, 40);
		add(menuPanel);
		menuPanel.setLayout(null);
		
		JPanel menuLeftPanel = new JPanel();
		menuLeftPanel.setBounds(0, 0, 300, 40);

		menuPanel.add(menuLeftPanel);
		menuLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuLeftPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		
		JButton makeRoomButton = new JButton("채팅방 생성");
		makeRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int activation = chatRooms.getActivation(); 
				if (activation == 5) {
					DialogManager.showMaxRoomDialog();
					return;
				}
				chatRooms.addActivation();
				chatRooms.getChatRoom(activation+1).getPanel().setVisible(true);
			}
		});
		makeRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(makeRoomButton);
		
		JButton deleteRoomButton = new JButton("채팅방 삭제");
		deleteRoomButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int activation = chatRooms.getActivation(); 
				if (activation == 1) {
					DialogManager.showMinRoomDialog();
					return;
				}
				chatRooms.getChatRoom(activation).getPanel().setVisible(false);
				chatRooms.reduceActivation();
			}
		});
		deleteRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(deleteRoomButton);
		
		JPanel menuCenterPanel = new JPanel();
		menuCenterPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		menuCenterPanel.setBounds(300, 0, 500, 40);
		menuPanel.add(menuCenterPanel);
		menuCenterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton memberButton = new JButton("대화상대");
		memberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 채팅방 인원 표시 구현
			}
		});
		memberButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuCenterPanel.add(memberButton);
		
		JPanel menuRightPanel = new JPanel();
		menuRightPanel.setBounds(800, 0, 200, 40);
		menuPanel.add(menuRightPanel);
		menuRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuRightPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		
		JButton profileButton = new JButton("프로필");
		profileButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuRightPanel.add(profileButton);
		
		JButton logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 로그아웃 물어보기
				DialogManager.showLogoutDialog();
			}
		});
		logoutButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuRightPanel.add(logoutButton);
		
		// 메뉴바 코드 시작
		JMenuBar leftMenuBar = new JMenuBar();
		leftMenuBar.setMargin(new Insets(0, 0, 5, 0));
		leftMenuBar.setBackground(new Color(255, 255, 255));
		leftMenuBar.setBounds(0, 0, 900, 23);
		add(leftMenuBar);
		
		JMenu settings = new JMenu("설정");
		settings.setBackground(new Color(255, 255, 255));
		settings.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		leftMenuBar.add(settings);
		
		// 설정 라디오 버튼 그룹 생성
        ButtonGroup windowLockGroup = new ButtonGroup();
		
		JMenu setWindow = new JMenu("창 변경 설정");
		settings.add(setWindow);
		
		JRadioButtonMenuItem windowLock = new JRadioButtonMenuItem("창 잠금");
		windowLock.setSelected(true);
		setWindow.add(windowLock);
		windowLockGroup.add(windowLock);
		
		JRadioButtonMenuItem windowUnlock = new JRadioButtonMenuItem("창 잠금 해제");
		setWindow.add(windowUnlock);
		windowLockGroup.add(windowUnlock);
		
		JMenuItem informMenuItem = new JMenuItem("(크기는 줄이기만 가능...)");
		informMenuItem.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		informMenuItem.setEnabled(false);
		setWindow.add(informMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setMargin(new Insets(0, 0, 5, 0));
		menuBar.setBounds(900, 0, 100, 23);
		add(menuBar);
		
		// 설정 라디오 버튼에 대한 ActionListener 추가
        ActionListener settingsRadioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (windowLock.isSelected()) {
                	FrameManager.getChatRoomFrame().setSize(1010, 530);
                    FrameManager.getChatRoomFrame().setResizable(false);
                } else if (windowUnlock.isSelected()) {
                	FrameManager.getChatRoomFrame().setResizable(true);
                }
            }
        };
        windowLock.addActionListener(settingsRadioListener);
        windowUnlock.addActionListener(settingsRadioListener);
        
        
        // 테마 메뉴
		JToggleButton darkmodeToggleButton = new JToggleButton("다크모드");
		darkmodeToggleButton.setHorizontalAlignment(SwingConstants.RIGHT);
		darkmodeToggleButton.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		menuBar.add(darkmodeToggleButton);
		
		JMenu theme = new JMenu("테마");
		theme.setBackground(new Color(255, 255, 255));
		theme.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		leftMenuBar.add(theme);
		
		JMenu selectTheme = new JMenu("테마 선택");
		theme.add(selectTheme);
		
		// 테마 라디오 버튼 그룹 생성
        ButtonGroup themeLockGroup = new ButtonGroup();
		
		JMenuItem themeFlatlaf = new JRadioButtonMenuItem("FlatLaf");
		selectTheme.add(themeFlatlaf);
		themeLockGroup.add(themeFlatlaf);
		
		JMenuItem themeMac = new JRadioButtonMenuItem("Mac");
		selectTheme.add(themeMac);
		themeLockGroup.add(themeMac);
		
		JMenuItem themeDacular = new JRadioButtonMenuItem("Darcular");
		selectTheme.add(themeDacular);
		themeLockGroup.add(themeDacular);
		
		JMenuItem themeIntelliJ = new JRadioButtonMenuItem("IntelliJ");
		selectTheme.add(themeIntelliJ);
		themeLockGroup.add(themeIntelliJ);
		
		JMenuItem themeArcIJ = new JRadioButtonMenuItem("ArcIJ");
		selectTheme.add(themeArcIJ);
		themeLockGroup.add(themeArcIJ);
		
		JMenuItem themeArcOrange = new JRadioButtonMenuItem("ArcOrange");
		selectTheme.add(themeArcOrange);
		themeLockGroup.add(themeArcOrange);
		
		JMenuItem themeCyanLight = new JRadioButtonMenuItem("CyanLight");
		themeCyanLight.setSelected(true);
		selectTheme.add(themeCyanLight);
		themeLockGroup.add(themeCyanLight);
		
		JMenuItem themeDarkPurple = new JRadioButtonMenuItem("DarkPurple");
		selectTheme.add(themeDarkPurple);
		themeLockGroup.add(themeDarkPurple);
		
		JMenuItem themeCarbon = new JRadioButtonMenuItem("Carbon");
		selectTheme.add(themeCarbon);
		themeLockGroup.add(themeCarbon);
		
		JRadioButtonMenuItem themeDefault = new JRadioButtonMenuItem("스윙 기본 테마");
		selectTheme.add(themeDefault);
		themeLockGroup.add(themeDefault);
		
		
		// 테마 라디오 버튼에 대한 ActionListener 추가
        ActionListener themeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JMenuItem source = (JMenuItem) e.getSource();
            	Themes themes = new Themes();
           
            	darkmodeToggleButton.setEnabled(false);        
            	
            	if (source == themeFlatlaf) {
            	    DialogManager.showThemeSelectDialog(themes.FlatLightLaf);
            	} else if (source == themeMac) {
            	    DialogManager.showThemeSelectDialog(themes.FlatMacLightLaf);
            	} else if (source == themeDacular) {
            	    DialogManager.showThemeSelectDialog(themes.FlatDarculaLaf);
            	} else if (source == themeIntelliJ) {
            	    DialogManager.showThemeSelectDialog(themes.FlatIntelliJLaf);
            	} else if (source == themeArcIJ) {
            	    DialogManager.showThemeSelectDialog(themes.FlatArcIJTheme);
            	} else if (source == themeArcOrange) {
            	    DialogManager.showThemeSelectDialog(themes.FlatArcOrangeIJTheme);
            	} else if (source == themeCyanLight) {
            	    DialogManager.showThemeSelectDialog(themes.FlatCyanLightIJTheme);
            	} else if (source == themeDarkPurple) {
            	    DialogManager.showThemeSelectDialog(themes.FlatDarkPurpleIJTheme);
            	} else if (source == themeCarbon) {
            	    DialogManager.showThemeSelectDialog(themes.FlatCarbonIJTheme);
            	} 
            	
            	// 스윙 기본테마로 돌아가기
            	else if (source == themeDefault) {
            		DialogManager.showThemeSelectDialog(themes.DefaultTheme);  
            	}
                
                // 다크모드 있는 테마일때 
                if (ThemeManager.hasDarkmode(ThemeManager.getCurrentTheme())) {
                	darkmodeToggleButton.setEnabled(true);  
                	darkmodeToggleButton.setSelected(false);
                }
            }
        };
        themeFlatlaf.addActionListener(themeListener);
        themeMac.addActionListener(themeListener);
        themeDacular.addActionListener(themeListener);
        themeIntelliJ.addActionListener(themeListener);
        themeArcIJ.addActionListener(themeListener);
        themeArcOrange.addActionListener(themeListener);
        themeCyanLight.addActionListener(themeListener);
        themeDarkPurple.addActionListener(themeListener);
        themeCarbon.addActionListener(themeListener);
        themeDefault.addActionListener(themeListener);
        
        // 다크모드에 대한 ActionListener 추가
        ActionListener darkmodeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LookAndFeel currentTheme = ThemeManager.getCurrentTheme();
            	Themes themes = new Themes();
            	
            	// 모드 바꾸기
            	ThemeManager.switchTheme(themes.getNegative(currentTheme));
            }
        };
        darkmodeToggleButton.addActionListener(darkmodeListener);
        
	}
}
