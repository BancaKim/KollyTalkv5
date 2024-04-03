package admin;

import javax.swing.*;

import user.EditProfileScreen;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminMenuScreen extends JFrame {
	private JButton noticeButton, editProfileButton, printChatLogbutton, button4, button5; // 새로운 버튼들 추가
	private String userId;
	private JLabel lblImage;

	public AdminMenuScreen(String userId) {
		this.userId = userId;
		setTitle("관리자 메뉴");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		lblImage = new JLabel(new ImageIcon("images/kollytalk.jpg"));
		lblImage.setHorizontalAlignment(JLabel.CENTER); // 레이블의 이미지를 가운데 정렬

		// 레이아웃 설정
		setLayout(new BorderLayout());
		add(lblImage, BorderLayout.NORTH); // 이미지 레이블을 상단에 추가

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		noticeButton = new JButton("공지기능");
		noticeButton.setPreferredSize(new Dimension(50, 50)); // 채팅방 입장 버튼 크기 조정
		noticeButton.setFont(new Font("@나눔스퀘어라운드", Font.BOLD, 25)); // 글꼴 크기 조정
		noticeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 공지사항 등록 버튼 눌렀을 때의 동작
				AdminNoticeScreen notice = new AdminNoticeScreen();
				notice.setVisible(true); // 공지사항 등록화면 띄우기
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		panel.add(noticeButton, gbc);

		// 회원조회
		editProfileButton = new JButton("회원조회");
		editProfileButton.setPreferredSize(new Dimension(50, 50)); // 내 정보 변경 버튼 크기 조정
		editProfileButton.setFont(new Font("@나눔스퀘어라운드", Font.BOLD, 25)); // 글꼴 크기 조정
		editProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 내 정보 변경 버튼 눌렀을 때의 동작
				SearchUserInfoScreen searchUserInfoScreen = new SearchUserInfoScreen();
				searchUserInfoScreen.setVisible(true);
				// 여기에 내 정보 변경 화면으로 이동하는 코드를 작성하세요
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		panel.add(editProfileButton, gbc);

		// 채팅조회
		printChatLogbutton = new JButton("채팅조회");
		printChatLogbutton.setPreferredSize(new Dimension(50, 50));
		printChatLogbutton.setFont(new Font("@나눔스퀘어라운드", Font.BOLD, 25));
		printChatLogbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 채팅조회 버튼 눌렀을 때의 동작
				PrintChatLogScreen printChatLogScreen = new PrintChatLogScreen();
				printChatLogScreen.setVisible(true);
//	            	printChatLogScreen.getMessageFromDatabase(userId,chatdate);
				// 여기에 채팅조회 화면으로 이동하는 코드를 작성하세요
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		panel.add(printChatLogbutton, gbc);

		button4 = new JButton("강퇴용어 등록");
		button4.setPreferredSize(new Dimension(50, 50));
		button4.setFont(new Font("나눔스퀘어라운드", Font.BOLD, 25));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		panel.add(button4, gbc);

		button5 = new JButton("회원삭제");
		button5.setPreferredSize(new Dimension(50, 50));
		button5.setFont(new Font("나눔스퀘어라운드", Font.BOLD, 25));
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원삭제 버튼 눌렀을 때의 동작
				DeleteUserInfoScreen deleteUserInfoScreen = new DeleteUserInfoScreen();
				deleteUserInfoScreen.setVisible(true);
			}
		});
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.weightx = 1.0;
		panel.add(button5, gbc);

		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AdminMenuScreen("");
			}
		});
	}
}