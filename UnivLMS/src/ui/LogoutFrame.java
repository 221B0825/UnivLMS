package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoutFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;
	private JButton logoutButton;
	private JButton cancelButton;

	public LogoutFrame(ActionListener logoutContinueActionHandler, ActionListener logoutCancelActionHandler) {

		// Frame 설정
		this.buttonPanel = new JPanel();
		this.logoutButton = new JButton("확인");
		this.cancelButton = new JButton("취소");
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

		this.setLocation(225, 225);
		this.setSize(330, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font font = new Font("맑은 고딕", Font.PLAIN, 18);
		// -------------------------------------------------------------------------------------------------

		// textPanel 설정
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(330, 30));
		textPanel.setBackground(Color.WHITE);

		JLabel logoutText = new JLabel("로그아웃 하시겠습니까?");
		logoutText.setFont(font);
		textPanel.add(logoutText);

		this.add(textPanel);

		// -------------------------------------------------------------------------------------------------

		// buttonPanel 설정
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
		buttonPanel.setPreferredSize(new Dimension(330, 170));
		buttonPanel.setBackground(Color.WHITE);

		// logoutButton 설정
		logoutButton.addActionListener(logoutContinueActionHandler);
		logoutButton.setBackground(new Color(1, 41, 102));
		logoutButton.setForeground(Color.WHITE);

		// cancelButton 설정
		cancelButton.addActionListener(logoutCancelActionHandler);
		cancelButton.setBackground(new Color(1, 41, 102));
		cancelButton.setForeground(Color.WHITE);

		buttonPanel.add(logoutButton);
		buttonPanel.add(cancelButton);

		this.add(buttonPanel);

	}
}
