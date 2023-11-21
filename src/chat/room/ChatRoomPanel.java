package chat.room;

import javax.swing.*;
import javax.swing.border.*;

import chat.dialog.DialogManager;
import chat.frame.FrameManager;
import chat.frame.ThemeManager;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;

public class ChatRoomPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ChatRoomPanel() {
		setBounds(0, 0, 1000, 560);
		setLayout(null);
		
		JPanel leftMenuPanel = new JPanel();
		leftMenuPanel.setBounds(0, 60, 300, 497);
		leftMenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
//		leftMenuPanel.setPreferredSize(new Dimension(300, 520));
		add(leftMenuPanel);
		leftMenuPanel.setLayout(null);
		
		JPanel roomSelctPanel = new JPanel();
		roomSelctPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel.setBounds(0, 0, 300, 100);
		leftMenuPanel.add(roomSelctPanel);
		roomSelctPanel.setLayout(null);
		
		JButton goButton = new JButton("");
		goButton.setBounds(238, 20, 50, 50);
		goButton.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/고뱃 입장 아이콘.png")));
		goButton.setBackground(Color.LIGHT_GRAY);
		roomSelctPanel.add(goButton);
		
		JButton roomTitleButton = new JButton("채팅방 1");
		roomTitleButton.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton.setBounds(12, 20, 214, 50);
		roomSelctPanel.add(roomTitleButton);
		
		JPanel roomSelctPanel1 = new JPanel();
		roomSelctPanel1.setLayout(null);
		roomSelctPanel1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel1.setBounds(0, 100, 300, 100);
		leftMenuPanel.add(roomSelctPanel1);
		
		JButton goButton_1 = new JButton("");
		goButton_1.setBackground(Color.LIGHT_GRAY);
		goButton_1.setBounds(238, 20, 50, 50);
		goButton_1.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/고뱃 입장 아이콘.png")));
		roomSelctPanel1.add(goButton_1);
		
		JButton roomTitleButton_1 = new JButton("채팅방 2");
		roomTitleButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton_1.setBounds(12, 20, 214, 50);
		roomSelctPanel1.add(roomTitleButton_1);
		
		JPanel roomSelctPanel2 = new JPanel();
		roomSelctPanel2.setLayout(null);
		roomSelctPanel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel2.setBounds(0, 200, 300, 100);
		leftMenuPanel.add(roomSelctPanel2);
		
		JButton goButton_2 = new JButton("");
		goButton_2.setBackground(Color.LIGHT_GRAY);
		goButton_2.setBounds(238, 20, 50, 50);
		goButton_2.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/고뱃 입장 아이콘.png")));
		roomSelctPanel2.add(goButton_2);
		
		JButton roomTitleButton_2 = new JButton("채팅방 3");
		roomTitleButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton_2.setBounds(12, 20, 214, 50);
		roomSelctPanel2.add(roomTitleButton_2);
		
		JPanel roomSelctPanel3 = new JPanel();
		roomSelctPanel3.setLayout(null);
		roomSelctPanel3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		roomSelctPanel3.setBounds(0, 300, 300, 100);
		leftMenuPanel.add(roomSelctPanel3);
		
		JButton goButton_2_1 = new JButton("");
		goButton_2_1.setBackground(Color.LIGHT_GRAY);
		goButton_2_1.setBounds(238, 20, 50, 50);
		goButton_2_1.setIcon(new ImageIcon(ChatRoomPanel.class.getResource("/Img/고뱃 입장 아이콘.png")));
		roomSelctPanel3.add(goButton_2_1);
		
		JButton roomTitleButton_2_1 = new JButton("채팅방 3");
		roomTitleButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		roomTitleButton_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		roomTitleButton_2_1.setBounds(12, 20, 214, 50);
		roomSelctPanel3.add(roomTitleButton_2_1);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(300, 60, 500, 497);
		centerPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
//		centerPanel.setPreferredSize(new Dimension(500, 520));
		add(centerPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		centerPanel.add(scrollPane);
		
		JPanel rightMenuPanel = new JPanel();
		rightMenuPanel.setBounds(800, 60, 200, 500);
		rightMenuPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), null));
//		songSelectPanel.setPreferredSize(new Dimension(200, 520));
		add(rightMenuPanel);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 20, 1000, 40);
//		menuPanel.setPreferredSize(new Dimension(1000, 40));
		add(menuPanel);
		menuPanel.setLayout(null);
		
		JPanel menuLeftPanel = new JPanel();
		menuLeftPanel.setBounds(0, 0, 300, 40);

		menuPanel.add(menuLeftPanel);
		menuLeftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		menuLeftPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		
		JButton makeRoomButton = new JButton("채팅방 생성");
		makeRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(makeRoomButton);
		
		JButton deleteRoomButton = new JButton("채팅방 삭제");
		deleteRoomButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuLeftPanel.add(deleteRoomButton);
		
		JPanel menuCenterPanel = new JPanel();
		menuCenterPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(128, 128, 128), null));
		menuCenterPanel.setBounds(300, 0, 500, 40);
		menuPanel.add(menuCenterPanel);
		menuCenterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton memberButton = new JButton("대화상대");
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
		
		// 라디오 버튼 그룹 생성
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
		informMenuItem.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 12));
		informMenuItem.setEnabled(false);
		setWindow.add(informMenuItem);
		
		// 라디오 버튼에 대한 ActionListener 추가
        ActionListener radioListener = new ActionListener() {
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
        windowLock.addActionListener(radioListener);
        windowUnlock.addActionListener(radioListener);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setMargin(new Insets(0, 0, 5, 0));
		menuBar.setBounds(900, 0, 100, 23);
		add(menuBar);
		
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
		
		JMenuItem Flatlaf = new JMenuItem("FlatLaf");
		selectTheme.add(Flatlaf);
		
		JMenuItem Mac = new JMenuItem("Mac");
		selectTheme.add(Mac);
		
		JMenuItem Dacular = new JMenuItem("Darcular");
		selectTheme.add(Dacular);
		
		JMenuItem IntelliJ = new JMenuItem("IntelliJ");
		selectTheme.add(IntelliJ);
		
		// 테마 버튼에 대한 ActionListener 추가
        ActionListener themeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JMenuItem source = (JMenuItem) e.getSource();
            	darkmodeToggleButton.setEnabled(true);
            	
                if (source == Flatlaf) {
                	DialogManager.showThemeSelectDialog(ThemeManager.themeFlatLightLaf);
                } else if (source == Mac) {
                	DialogManager.showThemeSelectDialog(ThemeManager.themeFlatMacLightLaf);
                } else if (source == Dacular) {
                	DialogManager.showThemeSelectDialog(ThemeManager.themeFlatDarculaLaf);
                	darkmodeToggleButton.setEnabled(false);
                } else if (source == IntelliJ) {
                	DialogManager.showThemeSelectDialog(ThemeManager.themeFlatIntelliJLaf);
                	darkmodeToggleButton.setEnabled(false);
                }
            }
        };
        Flatlaf.addActionListener(themeListener);
        Mac.addActionListener(themeListener);
        Dacular.addActionListener(themeListener);
        IntelliJ.addActionListener(themeListener);
        
     // 다크모드에 대한 ActionListener 추가
        ActionListener darkmodeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if (darkmodeToggleButton.isSelected()) {
            		if (ThemeManager.getCurrentTheme() instanceof FlatLightLaf) {
                		ThemeManager.switchTheme(ThemeManager.themeFlatDarkLaf);
                	} else if (ThemeManager.getCurrentTheme() instanceof FlatMacLightLaf) {
                		ThemeManager.switchTheme(ThemeManager.themeFlatMacDarkLaf);
                	}
            	} else {
            		if (ThemeManager.getCurrentTheme() instanceof FlatDarkLaf) {
                		ThemeManager.switchTheme(ThemeManager.themeFlatLightLaf);
                	} else if (ThemeManager.getCurrentTheme() instanceof FlatMacDarkLaf) {
                		ThemeManager.switchTheme(ThemeManager.themeFlatMacLightLaf);
                	}
            	}
            }
        };
        
        darkmodeToggleButton.addActionListener(darkmodeListener);
	}
}
